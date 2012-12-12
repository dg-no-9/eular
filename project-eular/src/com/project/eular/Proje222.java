package com.project.eular;

public class Proje222 {

	public static void main(String[] args) {
		double x = 0;
		double r1 = 50;
		double r2 = 30;
		System.out.println(x);

		int count = 0;
		while (count < 20) {

			x += r2 + Math.sqrt(2 * r1 * r2 - r2 * r2);
			System.out.println("count:"+ (count+1) + " r1:" + r1 + "  r2:" + r2 + "  x:" + x);

			double temp = r1;
			r1 = r2;
			if(count%2 == 0){
			r2 = temp - 1;
			}
			else r2 = temp + 1;
			
			
			/*r1--;
			r2++;
			if(r1==r2){
				r1--;
			}*/
			count++;
		}

		System.out.println((x + 50 + 40) * 1000);

	}

}
