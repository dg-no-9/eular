package com.project.eular;

public class Project243 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(gcd(2,5));
		System.out.println(R(12));
		double LIMIT = (double)15499/94744;
		System.out.println("LIMIT:" + LIMIT);
		
		System.out.println("Finished");

	}
	private static int gcd(int a, int b)
	{
	    while (b > 0)
	    {
	        int temp = b;
	        b = a % b; // % is remainder
	        a = temp;
	    }
	    return a;
	}

	private static double R(int d){
		double [] primes = new double [] {2,3,5,7,11,13,17,19};
		double value = (double)primes.length;
		double v2 = 1;
		for(int i = 0; i < primes.length; i++){
			value *= (1-1/primes[i]);
			v2*= primes[i];
		}
		return value/Math.pow(2, 10);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
