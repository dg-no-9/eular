package com.project.eular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project99 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("list.txt"));
		String line = br.readLine();
		int index = 0;
		int biggest = 0;
		double big = 0;
		double cur = 0;
		while (line != null)
		{
			double base = Integer.parseInt(line.split(",")[0]);
			double power = Integer.parseInt(line.split(",")[1]);
			cur = power * Math.log10(base);
			System.out.println(cur + " " + biggest);
			if(cur > big){
				big = cur;
				biggest = index;
			}
		    line = br.readLine();
		    index++;
		}

		System.out.println(biggest);
	}

}
