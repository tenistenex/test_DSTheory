package test_DSTheory;

import java.io.FileWriter;
import java.io.IOException;

public class Count {

	public static void main(String[] args) throws IOException {

		// set discount rate and initialize sensor//
		final Method method = new Method();
		Sensor scup = new Sensor("scup", 0.05);
		Sensor sfri = new Sensor("sfri", 0.05);
		Sensor swat = new Sensor("swat", 0.15);
		Sensor sket = new Sensor("sket", 0.30);
		Sensor stea = new Sensor("stea", 0.05);
		Sensor scof = new Sensor("scof", 0.05);
		Sensor ssug = new Sensor("ssug", 0.05);

		scup.set.put("on", 1.0);
		sfri.set.put("on", 1.0);
		swat.set.put("off", 1.0);
		sket.set.put("off", 1.0);
		stea.set.put("off", 1.0);   
		scof.set.put("off", 1.0);	
		ssug.set.put("off", 1.0);

		// count discount rate//
		scup = method.countRate(scup);
		sfri = method.countRate(sfri);
		swat = method.countRate(swat);
		sket = method.countRate(sket);
		stea = method.countRate(stea);
		scof = method.countRate(scof);
		ssug = method.countRate(ssug);
		
		// 進度: 設好初值，要簡介context的node有沒有問題

		System.out.println("sfir on:"+sfri.set.get("on"));
		System.out.println("sfir off:"+sfri.set.get("off"));
		System.out.println("sfir nor:"+sfri.set.get("nor"));
		//System.out.println(scup.set.get("on"));
		// set context and map
		//System.out.println("******contextA****");
		ContextA juice = new ContextA("juice",sfri,0.9);
		ContextA milk = new ContextA("milk",sfri,0.1);
		
		System.out.println("juice :"+juice.set.get("juice"));
		System.out.println("not_juice:"+juice.set.get("not_juice"));
		System.out.println("nor_juice:"+juice.set.get("nor_juice"));
		
		
		ContextB teaORcof = new ContextB("teaORcof", scof, stea);
		System.out.println("teaORcof :"+teaORcof.set.get("teaORcof"));
		System.out.println("not_teaORcof:"+teaORcof.set.get("not_teaORcof"));
		System.out.println("nor_teaORcof:"+teaORcof.set.get("nor_teaORcof"));
		
		
		System.out.println("******composite context*****");
		CompositeContext juiceAndcup = new CompositeContext("juiceAndcup");
		juiceAndcup.addMember(juice);
		juiceAndcup.addMember(scup);
		method.composite(juiceAndcup);
		System.out.print("juiceAndcup value:");
		System.out.println(juiceAndcup.set.get("juiceAndcup"));
		System.out.print("not juiceAndcup value:");
		System.out.println(juiceAndcup.set.get("not_juiceAndcup"));
		System.out.print("nor juiceAndcup value:");
		System.out.println(juiceAndcup.set.get("nor_juiceAndcup"));
		
		
		CompositeContext cwktORc = new CompositeContext("cwktORc");
		cwktORc.addMember(scup);
		cwktORc.addMember(swat);
		cwktORc.addMember(sket);
		cwktORc.addMember(teaORcof);
		method.composite(cwktORc);
		System.out.print("cwktORc value:");
		System.out.println(cwktORc.set.get("cwktORc"));
		System.out.print("not cwktORc value:");
		System.out.println(cwktORc.set.get("not_cwktORc"));
		System.out.print("nor cwktORc value:");
		System.out.println(cwktORc.set.get("nor_cwktORc"));
		
		
	/*	System.out.println("Translating to activity node");
		System.out.println("activity node : MakeColdDrink");*/
		Activity MakeColdDrink = new Activity("MakeColdDrink",juiceAndcup);
	/*	System.out.println(MakeColdDrink.set.get(MakeColdDrink.activityName));
		System.out.println(MakeColdDrink.set.get("not_"+MakeColdDrink.activityName));
		System.out.println(MakeColdDrink.set.get("nor_"+MakeColdDrink.activityName));*/
		
	/*	System.out.println("activity node : MakeHotDrink");*/
		Activity MakeHotDrink = new Activity("MakeHotDrink",cwktORc);
	/*	System.out.println(MakeHotDrink.set.get(MakeHotDrink.activityName));
		System.out.println(MakeHotDrink.set.get("not_"+MakeHotDrink.activityName));
		System.out.println(MakeHotDrink.set.get("nor_"+MakeHotDrink.activityName));*/
		
	//	System.out.println("activity node : MakeHotDrink2");
		Activity MakeHotDrink2 = new Activity("MakeHotDrink2",milk, 0.7);
	/*	System.out.println(MakeHotDrink2.set.get(MakeHotDrink2.activityName));
		System.out.println(MakeHotDrink2.set.get("not_"+MakeHotDrink2.activityName));
		System.out.println(MakeHotDrink2.set.get("nor_"+MakeHotDrink2.activityName));*/
		
	//	System.out.println("activity node : MakeHotDrink3");
		Activity MakeHotDrink3 = new Activity("MakeHotDrink3",ssug, 0.4);
	/*	System.out.println(MakeHotDrink3.set.get(MakeHotDrink3.activityName));
		System.out.println(MakeHotDrink3.set.get("not_"+MakeHotDrink3.activityName));
		System.out.println(MakeHotDrink3.set.get("nor_"+MakeHotDrink3.activityName));*/
		
	/*	System.out.println("Demphster Combination");
		System.out.println("MakeHotDrinkall value: ");*/
		Activity MakeHotDrinkall = new Activity();
		MakeHotDrinkall = method.DempsterCombination(MakeHotDrink, MakeHotDrink2);
		MakeHotDrinkall = method.DempsterCombination(MakeHotDrinkall, MakeHotDrink3);
		//MakeHotDrinkall = method.DempsterCombination(method.DempsterCombination(MakeHotDrink, MakeHotDrink2),MakeHotDrink3);
		System.out.println("MakeHotDrinkall:"+MakeHotDrinkall.set.get(MakeHotDrinkall.activityName));
		System.out.println("not_MakeHotDrinkall:"+MakeHotDrinkall.set.get("not_"+MakeHotDrinkall.activityName));
		System.out.println("nor_MakeHotDrinkall:"+MakeHotDrinkall.set.get("nor_"+MakeHotDrinkall.activityName));
		
		System.out.println("Belief and Plausibility");
		System.out.print("Bel(MakeColdDrink) :");
		System.out.println(method.Belief(MakeColdDrink));
		System.out.print("Pls(MakeColdDrink) :");
		System.out.println(method.Plausibility(MakeColdDrink));
		System.out.print("Bel(MakeHotDrink) :");
		System.out.println(method.Belief(MakeHotDrinkall));
		System.out.print("Pls(MakeHotDrink) :");
		System.out.println(method.Plausibility(MakeHotDrinkall));
		
        FileWriter fileWriter = new FileWriter("C:\\Users\\tenisten\\Desktop\\data.txt"); 
        
        String s = new String(String.valueOf(method.Belief(MakeColdDrink)));  
        String s1 = new String(String.valueOf(method.Belief(MakeHotDrinkall)));
        String s2 = new String(String.valueOf(method.Belief(MakeHotDrinkall)-method.Belief(MakeColdDrink)));
        fileWriter.write(s+" ");
        fileWriter.write(s1+" ");
        fileWriter.write(s2);
        fileWriter.close(); 

	}
}
