import java.util.HashMap;
import java.util.Map;

public class ContextA {
	String contextName;
	double mapValue;
	double value;
	Map<String, Double> set = new HashMap<String, Double>();

	public ContextA(Sensor s, String contextName, double mapValue) { 
																				
			if (s.set.get("on") != 0) {
				this.contextName = contextName;
				this.mapValue = mapValue;
				value = s.set.get("on") * mapValue;
				this.set.put(contextName, value);
				value = (1 - value); // context map to nor context
				this.set.put("un_" + contextName, value);
				value = s.set.get("off");
				this.set.put("not_" + contextName, value);
				value = s.set.get("nor");
				this.set.put("nor_" + contextName, value);
			}

	}
}
