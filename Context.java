package test_DSTheory;

import java.util.HashMap;
import java.util.Map;

public class Context {
	String contextName;
	double mapValue;
	double value;
	double a_value;
	double b_value;
	double not_a_value;
	double not_b_value;
	Map<String, Double> set = new HashMap<String, Double>();

	public Context(String contextName, Sensor s) {
		this.contextName = contextName;
		this.set.put(this.contextName, s.set.get("on"));
		this.set.put("not_"+this.contextName, s.set.get("off"));
		this.set.put("nor_"+this.contextName, s.set.get("nor"));
	}

	public Context(String contextName, Sensor s, double mapValue) {

		if (s.set.get("on") != 0) { // only compute the "sfri = on" context,need
									// to add off version
			this.contextName = contextName;
			this.mapValue = mapValue;
			value = s.set.get("on") * mapValue;
			this.set.put(contextName, value);
			// this configurations is adjust by yourself
			this.set.put("not_" + contextName, 0.0); // need to check again!
			this.set.put("nor_" + contextName, 1-value);

		} else {
			this.contextName = contextName;
			this.set.put(contextName, 0.0);
			this.set.put("not_" + contextName, 0.0);
			this.set.put("nor_" + contextName, 1.0);
		}

	}

	public Context(String contextName, Sensor a, Sensor b) {
		this.contextName = contextName;
		a_value = a.set.get("on");
		b_value = b.set.get("on");
		not_a_value = a.set.get("off");
		not_b_value = b.set.get("off");
		
		if (a_value != 0 && b_value != 0){
			if (a_value > b_value){
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
		
		else if (not_a_value != 0 && not_b_value != 0){
			if (not_a_value > not_b_value){
				set.put(this.contextName, 0.0);
				set.put("not_"+this.contextName, not_a_value);
				set.put("nor_"+this.contextName, 1-not_a_value);
			}
			else{
				set.put(this.contextName, 0.0);
				set.put("not_"+this.contextName, not_b_value);
				set.put("nor_"+this.contextName, 1-not_b_value);
			}
		}
		
		else if (a_value != 0 && not_b_value != 0){
			if (a_value > not_b_value){
				set.put(this.contextName, a_value);
				set.put("not_"+this.contextName, 0.0);
				set.put("nor_"+this.contextName, 1-a_value);
			}
			else{
				set.put(this.contextName, 0.0);
				set.put("not_"+this.contextName, not_b_value);
				set.put("nor_"+this.contextName, 1-not_b_value);
			}
		}
		
		else if (not_a_value != 0 && b_value != 0){
			if (not_a_value > b_value){
				set.put(this.contextName, 0.0);
				set.put("not_"+this.contextName, not_a_value);
				set.put("nor_"+this.contextName, 1-not_a_value);
			}
			else{
				set.put(this.contextName, b_value);
				set.put("not_"+this.contextName, 0.0);
				set.put("nor_"+this.contextName, 1-b_value);
			}
		}
		else {
			set.put(this.contextName, 0.0);
			set.put("not_"+this.contextName, 0.0);
			set.put("nor_"+this.contextName, 1.0);
		}
		
		
	}

}
