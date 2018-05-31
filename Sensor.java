package test_DSTheory;
import java.util.HashMap;
import java.util.Map;


public class Sensor {
	String sensorName;
	double discoutingRate;
	Map<String, Double> set = new HashMap<String, Double>();
    
	
	public Sensor(String name,double d){
		this.sensorName = name;
		this.discoutingRate = d;

		set.put("on", 0.0);
		set.put("off", 0.0);
		set.put("nor", 0.0);
	}
	
	
	
}