package com.project.eular;

import java.util.Arrays;
import java.util.List;

public class Problem199 {
	static double areaOccupied = 0;
	static final int depth = 10;
	public static void main(String[] args){
		double startR = 50;
		double r1,r2,r3;
		r1=r2=r3=startR;
		double r5 = getRadiusBig(r1, r2, r3);
		areaOccupied += getArea(r1) + getArea(r2) + getArea(r3);
		getCircle(r1,r2,r5,depth);
		getCircle(r2,r3,r5,depth);
		getCircle(r3,r1,r5,depth);
		getCircle(r1,r2,r3,depth);
		
		double fraction = (getArea(r5) - areaOccupied)/ getArea(r5);
		System.out.println("Fraction:" + fraction);
		
		
	}
	
	static public void getCircle(double r1, double r2, double r3,int depth){
		if(depth <= 0) return;
		List<Double> radList = Arrays.asList(r1,r2,r3);
		double r4 = getRadiusSmall(r1, r2, r3);
		areaOccupied += getArea(r4);
		depth--;
		for(int i = 0; i < 3; i++){
			getCircle(r4, radList.get(i%3),radList.get((i+1)%3),depth);
		}
	}
	
	
	
	public static  double getArea(double radius){
		return Math.PI * radius * radius;
	}
	
	public static double getRadiusBig(double r1, double r2, double r3){
		r1 = 1/r1;
		r2 = 1/r2;
		r3 = 1/r3;
		return 1/(r1+r2+r3 - 2 * Math.sqrt(r1*r2+ r2*r3+r3*r1));
	}
	
	public static double getRadiusSmall(double r1, double r2, double r3){
		r1 = 1/r1;
		r2 = 1/r2;
		r3 = 1/r3;
		return 1/(r1+r2+r3 + 2 * Math.sqrt(r1*r2+ r2*r3+r3*r1));
	}
	

}


