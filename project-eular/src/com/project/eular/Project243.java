package com.project.eular;

import java.util.Arrays;

public class Project243 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		double LIMIT = (double) 15499 / 94744;
		System.out.println(LIMIT);
		int [] primes = {2,3,5,7,11,13,17,19,23};
		long val = 2;
		for(int i = 1; i < primes.length; i++){
			val *= primes[i]; 
		}
		
		double res =  (double)phiL(val)/(val-1);
		while(res > LIMIT){
			val = val * 2;
			res =  (double)phiL(val)/(val-1);
		}
		
		System.out.println(res+ " " + val);
		

	}

	public static boolean isPermutable(int a, int b) {

		char[] xx = Integer.toString(a).toCharArray();
		char[] yy = Integer.toString(b).toCharArray();
		Arrays.sort(xx);
		Arrays.sort(yy);

		return Arrays.equals(xx, yy);
	}

	private static int gcdx(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b; // % is remainder
			a = temp;
		}
		return a;
	}
	
	private static void solve70(){
		double small = 2.0;
		for (int i = 2000; i < 5000; i++) {
			for (int j = 2000; j < 5000; j++) {
				if (i != j && i*j < 1_000_000_0) {
					if (isPrime(i) && isPrime(j)) {

						int phi = (i - 1) * (j - 1);
						if (small > (double) (i * j) / phi) {
							if (isPermutable(i * j, phi)) {
								small = (double) (i * j) / phi;
								System.out.println("SMALL DETECTED" + "A:" + i
										+ " B:" + j + " Value:" + (double) (i * j) / phi);

//								System.out.println("VAL:" + (double) (i * j)
//										/ phi + " " + i * j + " " + phi);
							}
						}
					}
				}
			}

		}
	}

	private static void solve69() {
		int i = 2;
		double big = 1.0;
		int last_i = i;
		while (true) {
			double phiRatio = ((double) i) / phi(i);
			if (big < phiRatio) {
				last_i = i;
				big = phiRatio;
			}
			i++;
			if (i > 1_000_000) {
				System.out.println(big + " " + last_i);
				break;
			}

		}
	}

	private static double R(int d) {

		return (double) phi(d) / (d - 1);
	}

	private static int gcd(int K, int M) {
		int k = K; // In order to state a simple, elegant loop invariant,
		int m = M; // we keep the formal arguments constant and use
					// local variables to do the calculations.
		// loop invariant: GCD(K,M) = GCD(k,m)
		while (k != m) {
			if (k > m) {
				k = k - m;
			} else {
				m = m - k;
			}
		}
		// At this point, GCD(K,M) = GCD(k,m) = GCD(k,k) = k
		return k;
	}

	static private int phi(int n) {
		// int n; //this is the number you want to find the totient of
		int tot = n; // this will be the totient at the end of the sample
		for (int p = 2; p * p <= n; p++) {
			if (n % p == 0) {
				tot /= p;
				tot *= (p - 1);
				while (n % p == 0)
					n /= p;
			}
		}
		if (n > 1) { // now n is the largest prime divisor
			tot /= n;
			tot *= (n - 1);
		}

		return tot;
	}
	
	static private long phiL(long n) {
		// int n; //this is the number you want to find the totient of
		long tot = n; // this will be the totient at the end of the sample
		for (int p = 2; p * p <= n; p++) {
			if (n % p == 0) {
				tot /= p;
				tot *= (p - 1);
				while (n % p == 0)
					n /= p;
			}
		}
		if (n > 1) { // now n is the largest prime divisor
			tot /= n;
			tot *= (n - 1);
		}

		return tot;
	}
	

	static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

}
