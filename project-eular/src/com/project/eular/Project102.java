package com.project.eular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project102 {

	/**
	 * @param args
	 */
	static final int SIZE = 1000;

	public static void main(String[] args) throws IOException {
		int x1 = -340;
		int y1 = 495;
		int x2 = -153;
		int y2 = -910;
		int x3 = 835;
		int y3 = -947;
		
		System.out.println(isOriginContainedBy(x1, y1, x2, y2, x3, y3));
		//System.out.println(isOriginContainedBy(0, 0, 20, 0, 10, 30, 10, 15));
		int[][] triangles = getTriangles();
		int count = 0;
		for (int i = 0; i < SIZE; i++) {
				if (isOriginContainedBy(triangles[i][0], triangles[i][1],
						triangles[i][2], triangles[i][3], triangles[i][4],
						triangles[i][5])){
					count++;
			}
		}
		
		System.out.println(count);

	}

	private static int[][] getTriangles() throws IOException {
		int[][] triangles = new int[SIZE][6];
		BufferedReader br = new BufferedReader(new FileReader("triangles.txt"));
		
		for (int i = 0; i < SIZE; i++) {
			String vertices[] = br.readLine().split(",");
			for (int j = 0; j < 6; j++) {
				triangles[i][j] = Integer.parseInt(vertices[j]);
			}
			
		}

		return triangles;
	}

	static boolean isOriginContainedBy(int x1, int y1, int x2, int y2, int x3,
			int y3) {
		double tt = getArea(-1, -1, 0, 1, 1, -1);
		System.out.println(tt);
		double orig = getArea(x1, y1, x2, y2, x3, y3);
		double a1 = getArea(x1, y1, x2, y2, 0, 0);
		double b1 = getArea(x1, y1, 0, 0, x3, y3);
		double c1 = getArea(0, 0, x2, y2, x3, y3);
		double val = a1+b1+c1;
		if (val == orig)
			return true;
		return false;
	}
	
	static double getArea(int x1, int y1, int x2, int y2, int x3,
			int y3) {
		double a = Math.abs((double)(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1-y2))/2);
		return a;
	}
	
	

}
