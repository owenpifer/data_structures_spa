package assignment3;

public class Main {
	public static void main(String[] args) {
		Grid grid1 = new Grid(10,10,15);
		Mouse mouse1 = new Mouse(grid1);
		mouse1.navigate();
		mouse1.printHistory();
		mouse1.printGrid();
		
	}

}
