package submarineGame;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Board board = new Board();
		board.printSubmarineMap();
		Scanner scanner = new Scanner(System.in);
		String input;
		input = scanner.nextLine();
		board.makeHit(input);
		board.printMap();
		

		

	}

}
