package test_DSTheory;

import java.math.BigDecimal;


public class Method {
	
	//couting discouting-rate//
	
	public Sensor countRate(Sensor sen){
		double value;
		double rate = sen.discoutRate;
		//////check sensor on or off equal 1 
		if (sen.set.get("on") != 0){
			value = sen.set.get("on") * (1 - rate);
			sen.set.put("on", value);
			sen.set.put("nor", new BigDecimal(1-value)
            .setScale(3, BigDecimal.ROUND_HALF_UP)
            .doubleValue());
		}
		else if (sen.set.get("off") != 0){
			value = sen.set.get("off") * (1 - rate);
			sen.set.put("off", value);
			sen.set.put("nor", new BigDecimal(1-value)
            .setScale(3, BigDecimal.ROUND_HALF_UP)
            .doubleValue());
		}
		else{
			sen.set.put("on", 0.0);
			sen.set.put("off", 0.0);
			sen.set.put("nor", 1.0);
		}
		return sen;
	}
	
	public CompositeContext composite(CompositeContext context){
		int i=0;
		Double value = 0.0;
		double notvalue = 0;
		double norvalue = 0;
		
		int memberCount = context.member.size();
		while(i < memberCount){
			Context c = context.member.get(i);
			value = value + c.set.get(c.contextName);
			notvalue = notvalue + c.set.get("not_"+c.contextName);
			norvalue = norvalue + c.set.get("nor_"+c.contextName);
		
			i++;
				}
			context.set.put(context.contextName, value/context.member.size());             //the value of context("on")!
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
