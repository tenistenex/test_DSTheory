package test_DSTheory;

import java.util.Arrays;

public class RunData {
	public static void main(String[] args) throws InterruptedException {

		String[] inputss = new String[8];
		String reinput="";

		char[] input = new char[8];
		for (int i = 0; i < 256; i++) {
			System.out.println("------------Round: "+i+"---start----------");
			//System.out.println(i);
			
			
			String x = Integer.toBinaryString(i).toString();
			input = x.toCharArray();

			for(int a =0;a< input.length;a++){
				reinput = reinput + input[a];
			}
			
			reinput = "00000000".substring(0, 8 - reinput.length()) + reinput;
			
			input = reinput.toCharArray();
			
			
		//	System.out.println("");
			for (int b = 0; b < input.length; b++) {
				if (input[b] == '1') {
					inputss[b] = "on";
				} else {
					inputss[b] = "nor";
				}

				 System.out.println(inputss[b]);
			}
			for (int c = 0; c < 8; c++) {
				if (inputss[c] == null) {
					inputss[c] = "nor";
				}
			//	System.out.println(inputss[c]);
			}
			
			Thread t  = new ResturantOntology(inputss);
			t.start();
			synchronized(t){
				t.wait();
			}
			
			System.out.println("------------Round: "+i+"---end----------");
			reinput="";
		}
	}
}
