package assignment3;

import java.util.ArrayList;
import java.util.Arrays;


public class Mouse {
	Grid grid1;
	ArrayList<int[]>currentPos = new ArrayList<int[]>();
	ArrayList<int[]>posHistory = new ArrayList<int[]>();
	public Mouse (Grid grid1) {
		this.grid1=grid1;
	}
	public void scanAndMove() {
		
		int x = currentPos.get(currentPos.size()-1)[0];
		int y = currentPos.get(currentPos.size()-1)[1];
		
		if(y>0&&x>0&&x<grid1.getXSize()&& y<grid1.getYSize()&&grid1.getNum(x-1,y-1) ==0) {
			currentPos.add(new int[] {x-1,y-1});
			grid1.move(x-1,y-1);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else if (y>=0&&x>0&&x<grid1.getXSize()&&y<grid1.getYSize()&& grid1.getNum(x-1,y) ==0 ) {
			
			currentPos.add(new int[] {x-1,y});
			grid1.move(x-1,y);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else if (y>=0&&x>0&&x<grid1.getXSize()-1&&y<grid1.getYSize()-1&& grid1.getNum(x-1,y+1) ==0 ) {
			currentPos.add(new int[] {x-1,y+1});
			grid1.move(x-1,y+1);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else if (y>=0&&x>=0&&x<grid1.getXSize()&&y<grid1.getYSize()-1&& grid1.getNum(x,y+1) ==0) {
			currentPos.add(new int[] {x,y+1});
			grid1.move(x,y+1);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else if (y>=0&&x>=0&&x<grid1.getXSize()-1&&y<grid1.getYSize()-1&& grid1.getNum(x+1,y+1) ==0) {
			currentPos.add(new int[] {x+1,y+1});
			grid1.move(x+1,y+1);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else if (y>=0&&x>=0&&x<grid1.getXSize()-1&&y<grid1.getYSize()&& grid1.getNum(x+1,y) ==0) {
			currentPos.add(new int[] {x+1,y});
			grid1.move(x+1, y);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else if (y>0&&x>=0&&x<grid1.getXSize()-1&&y<grid1.getYSize()&&grid1.getNum(x+1,y-1) ==0) {
			currentPos.add(new int[] {x+1,y-1});
			grid1.move(x+1,y-1);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else if (y>0&&x>=0&&x<grid1.getXSize()&&y<grid1.getYSize()&& grid1.getNum(x,y-1) ==0) {
			currentPos.add(new int[] {x,y-1});
			grid1.move(x,y-1);
			posHistory.add(currentPos.get(currentPos.size()-1));
		}
		else {
			
			currentPos.remove(currentPos.size()-1);
			posHistory.add(posHistory.get(posHistory.size()-2));
		}
	}
	public void printHistory() {
		for(int i = 0; i<posHistory.size(); i++) {
			//took next line from stack overflow https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
			// there's an arrays class in java.util that has a method that lets you print arrays
			System.out.print(Arrays.toString(posHistory.get(i)));
		}
	}
	public void printGrid() {
		System.out.println();
		grid1.printGrid();
	}
	public void navigate() {
		currentPos.add(new int[] {0,0});
		posHistory.add(new int[] {0,0});
		grid1.move(0, 0);
		boolean canMove = true;
		while(canMove == true) {
			scanAndMove();
			if(currentPos.size()==0) {
				canMove = false;
			}
		}
	}
	
	
}
