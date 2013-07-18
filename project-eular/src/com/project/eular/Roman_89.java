package com.dg.twiple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Roman_89 {
	
	
	public static void main(String ... args) throws IOException{
		System.out.println(getCount());
		//System.out.println(reduce("IIIIIIIIIIIIIIII"));
	}
	
	public static int getCount() throws IOException{
		File file = new File("roman.txt");
		FileReader reader = new FileReader(file);
		BufferedReader bf = new BufferedReader(reader);
		int count = 1;
		int originalLength = 0;
		int newLength = 0;
		String line = bf.readLine();
		while(line != null && line.length() > 0){
			originalLength += line.length();
			newLength += reduce(line).length();
			line = bf.readLine();
			count++;
		}
		
		return originalLength - newLength;
	}
	
	public static String reduce(String str){
		if(str.contains("VIIII")){
			str = str.replace("VIIII", "IX");
		}
		if(str.contains("LXXXX")){
			str = str.replace("LXXXX", "XC");
		}
		if(str.contains("DCCCC")){
			str = str.replace("DCCCC", "CM");
		}
		if(str.contains("IIII")){
			str = str.replace("IIII", "IV");
		}
		
		if(str.contains("XXXX")){
			str = str.replace("XXXX", "XL");
		}
		
		if(str.contains("CCCC")){
			str = str.replace("CCCC", "CD");
		}	
		return str;
	}
	
	
}
