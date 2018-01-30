package omnirobcontroller;

import omnirobcontroller.OmniRob;

public class Rule {

	public String applyRule(String rule, String restURI, String authToken){

		if (rule == "espresso") {
			OmniRob robotarm = new OmniRob();
			robotarm.moveToItem("espresso_pad", restURI, authToken, "true");
			robotarm.moveToItem("large_cup", restURI, authToken, "false");
			robotarm.moveToItem("milk", restURI, authToken, "true");
			robotarm.moveToItem("large_cup", restURI, authToken, "false");
			robotarm.moveToItem("sugar_white", restURI, authToken, "true");
			String resp =  robotarm.moveToItem("large_cup", restURI, authToken, "false");
			return resp;
		}		

		else if (rule == "soyCappuccino") {
			OmniRob robotarm = new OmniRob();
			robotarm.moveToItem("lungo_pad", restURI, authToken, "true");
			robotarm.moveToItem("large_cup", restURI, authToken, "false");
			robotarm.moveToItem("soy_milk", restURI, authToken, "true");
			robotarm.moveToItem("large_cup", restURI, authToken, "false");
			robotarm.moveToItem("sugar_white", restURI, authToken, "true");
			String resp = robotarm.moveToItem("large_cup", restURI, authToken, "false");
			return resp;
		}	

		else if (rule == "tea") {
			OmniRob robotarm = new OmniRob();
			robotarm.moveToItem("tee_bag", restURI, authToken, "true");
			robotarm.moveToItem("large_cup", restURI, authToken, "false");
			robotarm.moveToItem("milk", restURI, authToken, "true");
			robotarm.moveToItem("large_cup", restURI, authToken, "false");
			robotarm.moveToItem("sugar_white", restURI, authToken, "true");
			String resp = robotarm.moveToItem("large_cup", restURI, authToken, "false");
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
