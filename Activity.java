package test_DSTheory;

import java.util.HashMap;
import java.util.Map;

public class Activity {
	String activityName;
	Map<String, Double> set = new HashMap<String, Double>();
	
	
	
	public Activity(String activityName,CompositeContext context){
		double value;
		this.activityName = activityName;
		value = context.set.get(context.contextName);
		set.put(this.activityName, value);
		value = context.set.get("not_"+context.contextName);
		set.put("not_"+this.activityName, value);
		value = context.set.get("nor_"+context.contextName);
		set.put("nor_"+this.activityName, value);
	}
	
	public Activity(String activityName,Context context,double mapValue){
		double value = 0;
		this.activityName = activityName;
		
		if (context.set.get(context.contextName) != 0) {  
			value = context.set.get(context.contextName) * mapValue;
			this.set.put(this.activityName, value);
			value = (1 - value);                                                   // context map to nor context
			this.set.put("un_" + this.activityName, value);
			
			                                                                         // this configurations is adjust by yourself
			this.set.put("not_" +  this.activityName, 0.0);                            //need to check again!
			this.set.put("nor_" +  this.activityName, value);
			
		}
		
		else {
			this.set.put(this.activityName, 0.0);
			this.set.put("not_"+this.activityName, 0.0);
			this.set.put("nor_"+this.activityName, 1.0);
		}
		
		
	}
	
	public Activity(){
		
	}
	
	
}
