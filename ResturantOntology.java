package test_DSTheory;



public class ResturantOntology extends Thread{
	
	String[] input;
	
	public ResturantOntology(String[] input){
		this.input =input; 
	}
	public void run() {
		
		
		// TODO Auto-generated method stub
		
		synchronized(this){
		
		final Method method = new Method();
		
		Sensor scu = new Sensor("scu",0.1);
		Sensor sch = new Sensor("sch",0.1);
		Sensor sro = new Sensor("sro",0.1);
		Sensor sbo = new Sensor("sbo",0.1);
		Sensor scs = new Sensor("scs",0.1);
		Sensor ssp = new Sensor("ssp",0.1);
		Sensor sga = new Sensor("sga",0.1);
		Sensor sfi = new Sensor("sfi",0.1);
		
		
		
		scu.set.put(input[0], 1.0);
		sch.set.put(input[1], 1.0);
		sro.set.put(input[2], 1.0);
		sbo.set.put(input[3], 1.0);
		scs.set.put(input[4], 1.0);
		ssp.set.put(input[5], 1.0);
		sga.set.put(input[6], 1.0);
		sfi.set.put(input[7], 1.0);
		
		
		scu = method.countRate(scu);
		sch = method.countRate(sch);
		sro = method.countRate(sro);
		sbo = method.countRate(sbo);
		scs = method.countRate(scs);
		ssp = method.countRate(ssp);
		sga = method.countRate(sga);
		sfi = method.countRate(sfi);
		
		Context cup = new Context("cup",scu);
		Context cha = new Context("cha",sch);
		Context rob = new Context("rob",sro);
		Context bow = new Context("bow",sbo);
		Context cho = new Context("cho",scs);
		Context spo = new Context("spo",ssp);
		Context gas = new Context("gas",sga);
		Context fir = new Context("fir",sfi);
		
		Context drink = new Context("drink",cup,0.5);
		Context nodrink = new Context("nodrink",cup,0.5);
	
		Context havegas = new Context("havegas",gas,0.5);
		Context nogas = new Context("nogas",gas,0.5);
		
		Context ChOrSp = new Context("chOrsp",cho,spo);
		
		CompositeContext charob = new CompositeContext("charob");
		charob.addMember(cha);
		charob.addMember(rob);
		charob = method.composite(charob);
		
		CompositeContext cbdO = new CompositeContext("cbdO");
		cbdO.addMember(cha);
		cbdO.addMember(bow);
		cbdO.addMember(drink);
		cbdO.addMember(ChOrSp);
		cbdO = method.composite(cbdO);
		
		CompositeContext figa = new CompositeContext("figa");
		figa.addMember(fir);
		figa.addMember(havegas);
		figa = method.composite(figa);
		
		Activity NeedService = new Activity("NeedService",charob);
		Activity NeedService1 = new Activity("NeedService1",nodrink,0.5);
		Activity NeedService2 = new Activity("NeedService2",nogas,0.5);
		Activity NEEDSERVICE = method.DempsterCombination(method.DempsterCombination(NeedService,NeedService1), NeedService2);
		
		Activity Eating = new Activity("Eating",cbdO);
		Activity Eating1 = new Activity("Eating1",figa);
		
		Activity EATTING = method.DempsterCombination(Eating, Eating1);
		
		
		System.out.println("Belief and Plausibility");
		System.out.print("Bel(NEEDSERVICE) :");
		System.out.println(method.Belief(NEEDSERVICE));
		System.out.print("Pls(NEEDSERVICE) :");
		System.out.println(method.Plausibility(NEEDSERVICE));
		System.out.print("Pls(NEEDSERVICE)-Bel(NEEDSERVICE) :");
		System.out.println(method.Plausibility(NEEDSERVICE)-method.Belief(NEEDSERVICE));
		System.out.print("Bel(EATTING) :");
		System.out.println(method.Belief(EATTING));
		System.out.print("Pls(EATTING) :");
		System.out.println(method.Plausibility(EATTING));
		System.out.print("Pls(EATTING)-Bel(EATTING) :");
		System.out.println(method.Plausibility(EATTING)-method.Belief(EATTING));
		
		
		
		Thread write = new Writethread(NEEDSERVICE,EATTING,input);
		write.start();
		synchronized(write){
			try {
				write.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
       notify();
		
		}

	}

}
