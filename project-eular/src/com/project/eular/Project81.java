package com.project.eular;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Project81 {
	static final int SIZE = 80;

	public static void main(String[] args) throws IOException {
		int[][] grid = getGrid();
		System.out.println(getSolution());
		
	}

	static public int getSolution() throws IOException {
		int[][] grid = getGrid();
		Stack<Integer> stack = new Stack<>();
		int cur_i = SIZE - 1, cur_j = SIZE - 1;
		stack.push(grid[cur_i][cur_j]);
		for (int i = SIZE - 1; i >= 0; i--) {
			for (int j = SIZE - 1; j >= 0; j--) {
				int sumRight = -1;
				int sumDown = -1;
				if (j <= SIZE - 2) {
					sumRight = grid[i][j] + grid[i][j + 1];
				}
				if (i <= SIZE - 2) {
					sumDown = grid[i][j] + grid[i+1][j];;
				}
				if(sumDown == -1 && sumRight==-1){
					grid[i][j] = grid[i][j];
				}
				else if(sumDown == -1){
					grid[i][j] = sumRight; 
				}
				else if(sumRight == -1){
					grid[i][j] = sumDown;
				}
				else{
					if(sumRight > sumDown) grid[i][j] = sumDown;
					else grid[i][j] = sumRight;
				}
			}
		}
		return grid[0][0];
	}

	private static int[][] getGrid() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("matrix.txt"));

		int[][] grid = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			String[] line = br.readLine().split(",");
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = Integer.parseInt(line[j]);
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		return grid;
	}

	private static int[][] showGrid(int[][] grid) throws IOException {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		return grid;
	}

}
