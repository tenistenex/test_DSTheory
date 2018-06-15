package test_DSTheory;


import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Writethread extends Thread{
	
	final Method method = new Method();
	String[] input;
	double a_bel=0;
	double a_plu=0;
	double b_bel=0;
	double b_plu=0;
	
	public Writethread(Activity a,Activity b,String[] input){
		this.input=input;
		a_bel=method.Belief(a);
		a_plu=method.Plausibility(a);
		b_bel=method.Belief(b);
		b_plu=method.Plausibility(b);
		
	}
	
	public void run(){
		
		synchronized(this){
		
			FileWriter pw;
		try {
			pw = new  FileWriter("C:/Users/tenisten/Desktop/testdata.csv",true);
			 StringBuffer sb = new  StringBuffer();
			 	sb.append(input[0]);
		        sb.append(',');
		        sb.append(input[1]);
		        sb.append(',');
		        sb.append(input[2]);
		        sb.append(',');
		        sb.append(input[3]);
		        sb.append(',');
		        sb.append(input[4]);
		        sb.append(',');
		        sb.append(input[5]);
		        sb.append(',');
		        sb.append(input[6]);
		        sb.append(',');
		        sb.append(input[7]);
		        sb.append(',');
		        sb.append(a_bel);
		        sb.append(',');
		        sb.append(a_plu);
		        sb.append(',');
		        sb.append(b_bel);
		        sb.append(',');
		        sb.append(b_plu);
		        sb.append('\n');
		        
		        pw.append(sb.toString());
		        pw.close();
		   /*     System.out.println(a_bel);
		        System.out.println(a_plu);
		        System.out.println(b_bel);
		        System.out.println(b_plu);*/
		       
		        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notify();
		
		}
	}
}
