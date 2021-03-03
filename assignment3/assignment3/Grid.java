package assignment3;
import java.util.ArrayList;

import java.util.Random;

public class Grid {
	
	ArrayList<ArrayList<Integer>>coolGrid = new ArrayList<ArrayList<Integer>>();
	int n;
	int m;
	int k;
	
	
	public Grid(int n, int m, int k) {
		this.n = n;
		this.m = m;
		this.k = k;
		createGrid(n,m,k);
	}
	
	
	private void createGrid(int n, int m, int k){
		for(int i = 0; i< n; i++) {
			coolGrid.add(new ArrayList<Integer>());
		}
		for(int i = 0; i< n; i++) {
			for(int b = 0; b<m;b++) {
				coolGrid.get(i).add(0);
			}
		}
		
		for(int i = 0; i<k; i++) {
			Random r = new Random();
			int rand1 = r.nextInt(n);
			int rand2 = r.nextInt(m);
			coolGrid.get(rand1).set(rand2,1);
		}
		
	}
	public int getNum(int x, int y) {
		return coolGrid.get(x).get(y);
	}
	public void move(int x, int y) {
		coolGrid.get(x).set(y, 2);
	}
	public int[] findStartPos() {
		int[]returnInt = new int[2];
		for(int i = 0; i<coolGrid.size();i++) {
			for(int b = 0; b<coolGrid.get(i).size();b++) {
				if(coolGrid.get(i).get(b)==0) {
					returnInt[0] = i;
					returnInt[1] = b;
				}
			}
		}
		return returnInt;
	}
	public int getXSize() {
		return coolGrid.size();
	}
	public int getYSize() {
		return coolGrid.get(0).size();
	}
	public void printGrid() {
		for(int i = 0; i<coolGrid.size();i++) {
			System.out.println();
			for(int b = 0; b<coolGrid.get(i).size(); b++) {
				System.out.print(coolGrid.get(b).get(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		
	}
}
