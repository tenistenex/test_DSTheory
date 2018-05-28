
public class Method {
	
	//couting discouting-rate//
	
	public Sensor countRate(Sensor sen){
		Double value;
		double rate = sen.discoutingRate;
		//////check sensor on or off equal 1 
		if (sen.set.get("on") != 0){
			value = sen.set.get("on") * (1 - rate);
			sen.set.put("on", value);
			value = rate + (1 - rate)*sen.set.get("nor");
			sen.set.put("nor", value);
		}
		else{
			value = sen.set.get("off") * (1 - rate);
			sen.set.put("off", value);
			value = rate + (1 - rate)*sen.set.get("nor");
			sen.set.put("nor", value);
		}
		
		return sen;
	}
}
