package com.project.eular;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Project77 {

	static List<Integer> primes = new ArrayList<>();

	public static void main(String[] args) {
		int i = 2;
		int size = 100;
		while (i < size) {
			PushIfPrime(i);
			i++;
		}
		//getCoins(size);
		System.out.println("number: "+size+" Combinations:" +getCount(getPrimesBelow(size), size));
		

	}

	public static int getCount(List<Integer> primeList, int a) {
		if (a == 0) {
			return 1;
		} else if (a < 0) {
			return 0;
		} else if (primeList.size() == 0) {
			return 0;
		} else {
			int firstWay = getCount(getAllButFirst(primeList), a);
			int secondWay = getCount(primeList, a - primeList.get(0));
			return firstWay + secondWay;
		}
	}

	static public boolean PushIfPrime(int item) {
		if (!primes.contains(item)) {
			 if (BigInteger.valueOf(item).isProbablePrime(100)) {
			primes.add(item);
			return true;
			 }

			 return true;
		}
		return false;
	}

	static public List<Integer> getAllButFirst(List<Integer> list) {
		List<Integer> li = new ArrayList<>();
		for (int i = 1; i < list.size(); i++) {
			li.add(list.get(i));
		}
		return li;
	}
	
	public static void getCoins(int size){
		
		int [] ll = new int[]{1,2,5,10,20,50,100};
		for(int i=0; i<ll.length && ll[i] < size; i++){
			primes.add(ll[i]);
		}
	}

	static public List<Integer> getPrimesBelow(int x) {
		List<Integer> li = new ArrayList<>();
		for (int i = 0; i < primes.size(); i++) {
			if (primes.get(i) < x)
				li.add(primes.get(i));
		}
		return li;
	}

}
