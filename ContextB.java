package test_DSTheory;
import java.util.HashMap;
import java.util.Map;


public class ContextB {
	String contextName;
	double a_value;
	double b_value;
	double not_a_value;
	double not_b_value;
	
	Map<String, Double> set = new HashMap<String, Double>();
	
	public ContextB(String contextName,Sensor a, Sensor b){
		
		this.contextName = contextName;
	/*	 a_value = a.set.get("on");  //wrong version
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
		 }*/
		
		
		a_value = a.set.get("on");
		b_value = b.set.get("on");
		not_a_value = a.set.get("off");
		not_b_value = b.set.get("off");
		
		if (a_value != 0 && b_value != 0){
			if (a_value >= b_value){
				set.put(this.contextName, a_value);
				set.put("not_"+this.contextName, 0.0);
				set.put("nor_"+this.contextName, 1-a_value);
			}
			else{
				set.put(this.contextName, b_value);
				set.put("not_"+this.contextName, 0.0);
				set.put("nor_"+this.contextName, 1-b_value);
			}
			
		}
		
		else if(not_a_value != 0 && not_b_value != 0){
			if (not_a_value >= not_b_value){
				set.put(this.contextName, 0.0);
				set.put("not_"+this.contextName, not_a_value);
				set.put("nor_"+this.contextName, 1-not_a_value);
			}
			else{
				set.put(this.contextName, not_b_value);
				set.put("not_"+this.contextName, 0.0);
				set.put("nor_"+this.contextName, 1-not_b_value);
			}
		}
		
		else{
			set.put(this.contextName, 0.0);
			set.put("not_"+this.contextName, 0.0);
			set.put("nor_"+this.contextName, 1.0);
		}
		
		 
		 
		 
		  
		 
	}
}
