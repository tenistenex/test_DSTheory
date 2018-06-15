package test_DSTheory;

public class HomeOntology {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Method method = new Method();
		
		Sensor sca = new Sensor("sca",0);
		Sensor stv = new Sensor("stv",0);
		Sensor sbe = new Sensor("sbe",0);
		Sensor sli = new Sensor("sli",0);
		Sensor scl = new Sensor("scl",0);
		
		sca.set.put("on", 1.0);
		stv.set.put("on", 1.0);
		sbe.set.put("on", 1.0);
		sli.set.put("on", 1.0);
		scl.set.put("on", 1.0);
		
		sca = method.countRate(sca);
		stv = method.countRate(stv);
		sbe = method.countRate(sbe);
		sli = method.countRate(sli);
		scl = method.countRate(scl);
		
	/*	System.out.println(sca.set.get("on"));
		System.out.println(stv.set.get("on"));
		System.out.println(sbe.set.get("on"));
		System.out.println(sli.set.get("on"));
		System.out.println(scl.set.get("on"));*/
		
		Context card = new Context("card",sca);
		Context tv = new Context("tv",stv);
		Context bed = new Context("bed",sbe);
		Context light = new Context("light",sli);
		Context clock = new Context("clock",scl);
		Context day = new Context("day",light,0.5);
		Context night = new Context("night",light,0.5);
		
	/*	System.out.println(card.set.get("card"));
		System.out.println(tv.set.get("tv"));
		System.out.println(bed.set.get("bed"));
		System.out.println(light.set.get("light"));
		System.out.println(day.set.get("day"));
		System.out.println(night.set.get("night"));*/
		
		
		CompositeContext nightbedcard = new CompositeContext("nightbedcard");
		nightbedcard.addMember(card);
		nightbedcard.addMember(bed);
		nightbedcard.addMember(night);
		nightbedcard = method.composite(nightbedcard);
		
	/*	System.out.println(nightbedcard.set.get("nightbedcard"));
		System.out.println(nightbedcard.set.get("not_nightbedcard"));
		System.out.println(nightbedcard.set.get("nor_nightbedcard")); */
		
		
		CompositeContext tvdaycard = new CompositeContext("tvdaycard");
		tvdaycard.addMember(tv);
		tvdaycard.addMember(day);
		tvdaycard.addMember(card);
		tvdaycard = method.composite(tvdaycard);
		
	/*	System.out.println(tvlightcard.set.get("tvdaycard"));
		System.out.println(tvlightcard.set.get("not_tvdaycard"));
		System.out.println(tvlightcard.set.get("nor_tvdaycard"));*/
		
		Activity Sleep = new Activity("Sleep",nightbedcard);
		Activity Sleep1 = new Activity("Sleep1",clock,0.5);
		Activity SLEEP = method.DempsterCombination(Sleep, Sleep1);
		
		Activity WatchTv = new Activity("WatchTv",tvdaycard);
		
		System.out.println("Belief and Plausibility");
		System.out.print("Bel(Sleep) :");
		System.out.println(method.Belief(SLEEP));
		System.out.print("Pls(Sleep) :");
		System.out.println(method.Plausibility(SLEEP));
		System.out.print("Bel(WatchTv) :");
		System.out.println(method.Belief(WatchTv));
		System.out.print("Pls(WatchTv) :");
		System.out.println(method.Plausibility(WatchTv));
		
		
		
		
		
		
		
		
	}

}
