package test_DSTheory;


public class Method {
	
	//couting discouting-rate//
	
	public Sensor countRate(Sensor sen){
		double value;
		double rate = sen.discoutRate;
		//////check sensor on or off equal 1 
		if (sen.set.get("on") != 0){
			value = sen.set.get("on") * (1 - rate);
			sen.set.put("on", value);
			value = rate + (1 - rate)*sen.set.get("nor");
			sen.set.put("nor", value);
		}
		else if (sen.set.get("off") != 0){
			value = sen.set.get("off") * (1 - rate);
			sen.set.put("off", value);
			value = rate + (1 - rate)*sen.set.get("nor");
			sen.set.put("nor", value);
		}
		else{
			sen.set.put("on", 0.0);
			sen.set.put("off", 0.0);
			sen.set.put("nor", 1.0);
		}
		return sen;
	}
	
	public CompositeContext composite(CompositeContext context){
		//System.out.println("composite!!!!!");
		int i=0;
		Double value = 0.0;
		double notvalue = 0;
		double norvalue = 0;
		
		int memberCount = context.member.size();
		//System.out.println(context.member.get(1).getClass().getName().toString());   //this line print the object which class is
		while(i < memberCount){
			Context c = context.member.get(i);
			//System.out.println(i);
			//System.out.println(c.contextName);
			value = value + c.set.get(c.contextName);
			notvalue = notvalue + c.set.get("not_"+c.contextName);
			norvalue = norvalue + c.set.get("nor_"+c.contextName);
		/*		switch(context.member.get(i).getClass().getName().toString()){
				case "test_DSTheory.Sensor":
					Sensor s = (Sensor)context.member.get(i);
					value = value + s.set.get("on");
					notvalue = notvalue + s.set.get("off");
					norvalue = norvalue + s.set.get("nor");
					//System.out.println("Object is Sensor");
					break;
				
				case "test_DSTheory.ContextA":
					ContextA a = (ContextA)context.member.get(i);
					value = value + a.set.get(a.contextName);
					notvalue = notvalue + a.set.get("not_"+a.contextName);
					norvalue = norvalue + a.set.get("nor_"+a.contextName);
					//System.out.println("Object is ContextA");
					break;
					
				case "test_DSTheory.ContextB":
					ContextB b = (ContextB)context.member.get(i);
					value = value + b.set.get(b.contextName);
					notvalue = notvalue + b.set.get("not_"+b.contextName);
					norvalue = norvalue + b.set.get("nor_"+b.contextName);
					//System.out.println("Object is ContextB");
					break;*/
			//System.out.println("---------------");
			i++;
				}
			context.set.put(context.contextName, value/context.member.size());  //the value of context("on")!
			context.set.put("not_"+context.contextName, notvalue/context.member.size());
			context.set.put("nor_"+context.contextName, norvalue/context.member.size());
			
		
		return context;
		
	}
	
	public Activity DempsterCombination(Activity a, Activity b){
		double value;
		double notvalue;
		double norvalue;
		Activity c = new Activity();
		c.activityName = a.activityName;
		
		value = (a.set.get(a.activityName)*b.set.get(b.activityName) + a.set.get("nor_"+a.activityName)*b.set.get(b.activityName) + a.set.get(a.activityName)*b.set.get("nor_"+b.activityName))/(1-(a.set.get(a.activityName)*b.set.get("not_"+b.activityName)+a.set.get("not_"+a.activityName)*b.set.get(b.activityName)));
		c.set.put(c.activityName, value);
		notvalue = (a.set.get("not_" + a.activityName)*b.set.get("not_" + b.activityName) + a.set.get("nor_" + a.activityName)*b.set.get("not_" + b.activityName)+a.set.get("not_" + a.activityName)*b.set.get("nor_" + b.activityName))/(1-(a.set.get(a.activityName)*b.set.get("not_"+b.activityName)+a.set.get("not_"+a.activityName)*b.set.get(b.activityName)));
		c.set.put("not_"+c.activityName, notvalue);
		norvalue = 1-(value+notvalue);
		c.set.put("nor_"+c.activityName, norvalue);
		return c;
	}
	
	public double Belief(Activity a){
		return a.set.get(a.activityName);
	}
	
	public double Plausibility(Activity a){
		return a.set.get(a.activityName) + a.set.get("nor_"+a.activityName);
	}
}
