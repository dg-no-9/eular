package com.project.eular;

public class Project398 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test();
		int product = 0;
		int prev_count = 0;
		int count = 0;
		int a = 0, b = 0;

		for (int i = 999; i > -1000; i--) {
			for (int j = 999; j > -1000; j--) {
				int n = 0;
				count = 0;
				int value = 0;

				while (true) {
					// System.out.println("a:" + a + " b:" + b + " n:" + n);
					value = n * n + i * n + j;
					if (!isPrime(value)) {
						break;
					} else {
						a = i;
						b = j;
						count++;
						n++;
					}
				}
				if (count > prev_count) {
					product = a * b;
					prev_count = count;
				}
			}
		}

		System.out.println(product + " " + a + " " + b + " " + count);

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

	static void test() {
		int count = 0;
		int prev_count = 0;
		int product = 0;
		int a = -79;
		int b = 1601;
		int n = 0;
		count = 0;
		int value = n * n + a * n + b;

		while (isPrime(value)) {
			// System.out.println("a:" + a + " b:" + b + " n:" + n);
			value = n * n + a * n + b;
			count++;
			n++;
		}
		if (count > prev_count) {
			product = a * b;
		}
		System.out.println(product);
	}
}
