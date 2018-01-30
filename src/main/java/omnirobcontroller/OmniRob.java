package omnirobcontroller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class OmniRob {

	public String moveToItem(String item, String restURI, String authToken, String flag){

		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.OFF); 

		int itemX = getCoordinate(item, "X");
		int itemY = getCoordinate(item, "Y");
		int itemZ = getCoordinate(item, "Z");

		moveArm(itemX, itemY, 160, restURI, authToken);
		moveArm(itemX, itemY, itemZ, restURI, authToken);
		grabOn(flag, restURI, authToken);
		String res = moveArm(itemX, itemY, 160, restURI, authToken);
		
		return res;
		
	}	

	public int getCoordinate(String item, String xyz){
		Model coffeeOntology = FileManager.get().loadModel("https://uni.asilcetin.com/cmke/coffeeOntology.rdf");
		String Namespace = "http://austria.omilab.org/omirob/omiarm1/ontology/coffee/";
		Resource resource = coffeeOntology.getResource(Namespace+item);
		Property coordinate = coffeeOntology.getProperty(Namespace+"has"+xyz+"-coordinate");
		int result = resource.getProperty(coordinate).getInt();
		System.out.print(result);
		return result;
	}	

	
	public String reset(String restURI, String authToken){
		Client client = ClientBuilder.newClient();
		WebTarget path = client.target(restURI + "/reset");

		String resp = path
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+authToken)
		        .post(null)
		        .readEntity(String.class);
		
	    return resp;
	}
	
	private String moveArm(int x, int y, int z, String restURI, String authToken){
		Client client = ClientBuilder.newClient();
		WebTarget path = client.target(restURI + "/positionXYZ");
		String coordinates = "{\"x\":"+x+",\"y\":"+y+",\"z\":"+z+"}";
		String resp = path
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+authToken)
		        .put(Entity.json(coordinates))
		        .readEntity(String.class);
		//System.out.print(coordinates);
	    return resp;
	}
	

	public String grabOn(String flag, String restURI, String authToken){
		/*
		Client client = ClientBuilder.newClient();
		//client.register(new LoggingFilter());
		WebTarget path = client.target("http://austria.omilab.org/omirob/dobot1/rest/grabOn");
		String grabFlag = flag;
		String resp = path
				.request(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer "+authToken)			
		        .post(Entity.json(grabFlag))
		        .readEntity(String.class);
		*/

		HttpResponse<String> response;
		try {
			response = Unirest.post(restURI + "/grabOn")
					  .header("Content-Type", "application/json")
					  .header("Cache-Control", "no-cache")
					  .header("Authorization", "Bearer "+authToken)
					  .body(flag)
					  .asString();

			String resp = response.getStatusText();
			
		    return resp;				
			
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		
		return "Error, please check your settings.";

	}
	
	
}
