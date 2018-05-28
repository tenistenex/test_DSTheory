
public class Count {
	
	
	public static void main(String[] args) {
		
		//set discount rate and initialize sensor//
		final Method method = new Method();
        Sensor scup = new Sensor("scup",0.05);
        Sensor sfri = new Sensor("sfri",0.05);
        Sensor swat = new Sensor("swat",0.15);
        Sensor sket = new Sensor("sket",0.30);
        Sensor stea = new Sensor("stea",0.05);
        Sensor scof = new Sensor("scof",0.05);
        Sensor ssug = new Sensor("ssug",0.05);
        
        sfri.set.put("on", 1.0);
        scof.set.put("off", 1.0);
        stea.set.put("off", 1.0);
        scup.set.put("on", 1.0);
        
        //count discount rate//
        sfri = method.countRate(sfri);
        scof = method.countRate(scof);
        stea = method.countRate(stea);
        scup =  method.countRate(scup);
        
    //    System.out.println(sfri.set.get("on"));
        System.out.println(scup.set.get("on"));
      //set context and map
        System.out.println("******contextA****");
        ContextA juice = new ContextA(sfri,"juice",0.9);  
        System.out.println(juice.set.get("juice"));
   /*     System.out.println(juice.set.get("un_juice"));
        System.out.println(juice.set.get("not_juice"));
        System.out.println(juice.set.get("nor_juice"));
        ContextA milk = new ContextA(sfri,"milk",0.1);*/
       /* System.out.println("milk");
        System.out.println(milk.set.get("milk"));
        System.out.println(milk.set.get("un_milk"));
        System.out.println(milk.set.get("not_milk"));
        System.out.println(milk.set.get("nor_milk"));
        
        System.out.println("******contextB*****");
        ContextB teaORcof = new ContextB("teaORcof",scof,stea);
        System.out.println(teaORcof.set.get("teaORcof"));
        System.out.println(teaORcof.set.get("not_teaORcof"));
        System.out.println(teaORcof.set.get("nor_teaORcof"));*/
        
        System.out.println("******composite context*****");
        CompositeContext juiceAndcup = new CompositeContext("juiceAndcup");
        juiceAndcup.addMember(juice);
        juiceAndcup.addMember(scup);
        method.composite(juiceAndcup);
        System.out.println(juiceAndcup.set.get("juiceAndcup"));
        
        
        
        
    }
}
