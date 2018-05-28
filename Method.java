
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
	
	public CompositeContext composite(CompositeContext context){
		System.out.println("composite!!!!!");
		double value = 0;
		int memberCount = context.member.size();
		for (int i=0; i < memberCount; i++){
				switch(context.member.get(i).getClass().toString()){
				case "class Sensor":
					Sensor s = (Sensor)context.member.get(i);
					value = value + s.set.get("on");
					System.out.println("Object is Sensor");
					break;
				
				case "class ContextA":
					ContextA a = (ContextA)context.member.get(i);
					value = value + a.set.get(a.contextName);
					System.out.println("Object is ContextA");
					break;
					
				case "ContextB":
					ContextB b = (ContextB)context.member.get(i);
					value = value + b.set.get(b.contextName);
					System.out.println("Object is ContextB");
					break;
				}
				System.out.println(value);
				
			context.set.put(context.contextName, value/(i+1));  //the value of context("on")!
			}
		
		return context;
		
	}
}
