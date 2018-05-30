package test_DSTheory;
import java.util.HashMap;
import java.util.Map;


public class ContextB {
	String contextName;
	double a_value;
	double b_value;
	
	Map<String, Double> set = new HashMap<String, Double>();
	
	public ContextB(String contextName,Sensor a, Sensor b){
		
		this.contextName = contextName;
		 a_value = a.set.get("on");
		 b_value = b.set.get("on"); 
		 if (a_value > b_value){
			 set.put(contextName, a_value);
		 } 
		 else{
			 set.put(contextName, b_value);
		 }
		 a_value = a.set.get("off");
		 b_value = b.set.get("off");
		 
		 if (a_value > b_value){
			 set.put("not_"+contextName, a_value);
		 } 
		 else{
			 set.put("not_"+contextName, b_value);
		 }
		 
		 a_value = a.set.get("nor");
		 b_value = b.set.get("nor");
		 
		 if (a_value > b_value){
			 set.put("nor_"+contextName, a_value);
		 } 
		 else{
			 set.put("nor_"+contextName, b_value);
		 }
		 
		 
		 
		  
		 
	}
}
