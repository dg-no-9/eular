package com.project.eular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Project102 {

	/**
	 * @param args
	 */
	static final int  SIZE = 1000;
	public static void main(String[] args) throws IOException {
		int [][] triangles = getTriangles();
		for(int i = 0; i < SIZE; i++){
			
		}

	}
	
	private static int[][] getTriangles() throws IOException{
		int [][] triangles = new int[SIZE][6];
		BufferedReader br = new BufferedReader(new FileReader("triangles.txt"));
		String vertices[] = br.readLine().split(",");
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < 6; j++){
				triangles[i][j] = Integer.parseInt(vertices[j]);
			}
		}
		
		return triangles;
	}

}
