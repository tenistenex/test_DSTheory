package test_DSTheory;

import java.util.HashMap;
import java.util.Map;

public class ContextA {
	String contextName;
	double mapValue;
	double value;
	Map<String, Double> set = new HashMap<String, Double>();

	public ContextA(String contextName,Sensor s,double mapValue) { 
																				
			if (s.set.get("on") != 0) {  //only compute the "sfri = on" context,need to add  off version
				this.contextName = contextName;
				this.mapValue = mapValue;
				value = s.set.get("on") * mapValue;
				this.set.put(contextName, value);
				value = (1 - value); // context map to nor context
				this.set.put("un_" + contextName, value);
				
				// this configurations is adjust by yourself
				this.set.put("not_" + contextName, 0.0);    //need to check again!
				this.set.put("nor_" + contextName, value);
				
			}

	}
}
