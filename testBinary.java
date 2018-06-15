package test_DSTheory;

import java.util.ArrayList;
import java.util.Arrays;

public class testBinary {
	public static void main(String[] args) {
		
		char[] input = new char[8];
		char[] reinput = new char[8];
		String xxx="";
		
		
		
		
		for(int i=0;i<20;i++){
		String x = Integer.toBinaryString(i).toString();
	//	System.out.println(x);
		input = x.toCharArray();
		for(int a =0;a<input.length;a++){
			xxx = xxx + input[a];
		}
		
		xxx = "00000000".substring(0, 8 - xxx.length()) + xxx;
		
		reinput = xxx.toCharArray();
	
		
		
		
		for (int a = 0; a <reinput.length; a++) {
			System.out.print(reinput[a]);
		}
		
		System.out.println("-------------");
		xxx="";
		}
		}
	
}
