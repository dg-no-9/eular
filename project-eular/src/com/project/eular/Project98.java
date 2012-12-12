package com.project.eular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project98 {
	static int A = 'A' - 1;
	static int SIZE = 5;

	public static void main(String[] str) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("words.txt"));
		List<String> anagrams = new ArrayList<>();
		String line = br.readLine();
		String[] words = line.split(",");
		SIZE = words.length;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i != j) {

					if (areAnagrams(words[i], words[j])) {
						if (!alreadyPresent(anagrams, words[i])) {
							anagrams.add(words[i] + "," + words[j] + ","
									+ words[j].length());
						}
					}

				}
			}
		}
		int largestSize = 1;
		for (int i = 0; i < anagrams.size(); i++) {
			int curSize = anagrams.get(i).split(",")[0].length();
			if (curSize > largestSize) {
				largestSize = curSize;
			}
		}
		largestSize -= 2;
		for (int i = 0; i < anagrams.size(); i++) {
			String cur = anagrams.get(i).split(",")[0];
			if (anagrams.get(i).split(",")[0].length() == largestSize) {
				System.out.println(anagrams.get(i).split(",")[0] + " "
						+ anagrams.get(i).split(",")[1]);
			}
		}
		// getLargestSquare(largestSize, anagrams);
		getLargestSquareXXX(largestSize, anagrams);
		System.out.println(anagrams.size() + "Largest:" + largestSize);
	}

	public static boolean alreadyPresent(List<String> anagrams, String word) {
		for (int i = 0; i < anagrams.size(); i++) {
			if (anagrams.get(i).split(",")[0].equals(word)
					|| anagrams.get(i).split(",")[1].equals(word)) {
				return true;
			}
		}
		return false;
	}

	static public boolean areAnagrams(String str1, String str2) {
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		return Arrays.equals(ch1, ch2);
	}

	static public int getLargestSquare(int largestSize, List<String> anagrams) {
		int theNumIKnow = (int) Math.sqrt(Math.pow(10, largestSize - 2));
		for (int i = theNumIKnow; i > (theNumIKnow / 3) + 1; i--) {
			int[] digits = new int[largestSize - 2];
			int value = i * i;
			for (int j = largestSize - 3; j >= 0; j--) {
				digits[j] = value % 10;
				value /= 10;
			}

			for (int j = 0; j < anagrams.size(); j++) {
				Map<Character, Integer> map = new HashMap<Character, Integer>();
				if (anagrams.get(j).split(",")[0].length() == largestSize) {
					String anagramLeft = anagrams.get(j).split(",")[0];
					for (int k = 1; k < anagramLeft.length() - 1; k++) {
						map.put(anagramLeft.charAt(k), digits[k - 1]);
					}
					int newValue = 0;
					String anagramRight = anagrams.get(j).split(",")[1];
					for (int k = 1; k < anagramRight.length() - 1; k++) {
						newValue = map.get(anagramRight.charAt(k)) + newValue
								* 10;
					}

					int temp = (int) Math.sqrt(newValue);
					System.out.println(anagramLeft + " " + anagramRight + " "
							+ i * i + " " + newValue);
					if (temp * temp == newValue) {
						System.out.println("Largest SQUARE:" + value
								+ anagramLeft + " " + anagramRight);
						return value;
					}
				}
			}
			largestSize--;

		}
		return 0;
	}

	static public int getLargestSquareXXX(int largestSize, List<String> anagrams) {

		int theNumIKnow = (int) Math.sqrt(Math.pow(10, largestSize));
		for (int j = 0; j < anagrams.size(); j++) {
			String curLeft = anagrams.get(j).split(",")[0];
			if (curLeft.length() == largestSize + 2) {
				for (int i = theNumIKnow; i > (theNumIKnow / 3) + 1; i--) {
					int value = i*i;
					int [] digits = new int[largestSize];
					for (int k = largestSize - 1; k >= 0; k--) {
						digits[k] = value % 10;
						value /= 10;
					}
					Map<Character, Integer> map = new HashMap<>();
					for(int k = 0; k < largestSize; k++){
						map.put(curLeft.charAt(k+1), digits[k]);
					}
				String curRight = anagrams.get(j).split(",")[1];
				for(int k = 0; k < largestSize; k++){
					
				}
					
					
				}
			}
		}

		return 0;
	}
}
