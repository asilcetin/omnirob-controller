package omnirobcontroller;

import omnirobcontroller.OmniRob;

public class Rule {

	public String applyRule(String rule, String restURI, String authToken){

		if (rule == "espresso") {
			OmniRob robotarm = new OmniRob();
			robotarm.moveToItem("espresso_pad", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			robotarm.grabOn("false", restURI, authToken);
			robotarm.moveToItem("milk", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			robotarm.grabOn("false", restURI, authToken);
			robotarm.moveToItem("sugar_white", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			String resp =  robotarm.grabOn("false", restURI, authToken);
			return resp;
		}		

		else if (rule == "soyCappuccino") {
			OmniRob robotarm = new OmniRob();
			robotarm.moveToItem("lungo_pad", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			robotarm.grabOn("false", restURI, authToken);
			robotarm.moveToItem("soy_milk", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			robotarm.grabOn("false", restURI, authToken);
			robotarm.moveToItem("sugar_white", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			String resp = robotarm.grabOn("false", restURI, authToken);
			return resp;
		}	

		else if (rule == "tea") {
			OmniRob robotarm = new OmniRob();
			robotarm.moveToItem("tee_bag", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			robotarm.grabOn("false", restURI, authToken);
			robotarm.moveToItem("milk", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			robotarm.grabOn("false", restURI, authToken);
			robotarm.moveToItem("sugar_white", restURI, authToken);
			robotarm.grabOn("true", restURI, authToken);
			robotarm.moveToItem("large_cup", restURI, authToken);
			String resp = robotarm.grabOn("false", restURI, authToken);
			return resp;
		}		
		
		else if (rule == "reset") {
			OmniRob robotarm = new OmniRob();
			String resp = robotarm.reset(restURI, authToken);
			return resp;
		}
		
		return "Error; Cannot apply the rule.";
		
	}
	
	
}
