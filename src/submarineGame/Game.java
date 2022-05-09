package submarineGame;

import java.util.Scanner;

public class Game {
	private Board board;
	private int guesses = 100;
	private int points = 1000;

	public Game(Board board) {
		this.board = board;
	}

	public void run() throws OutOfBoardException  {
		Scanner scanner = new Scanner(System.in);
		printStats();
		board.printMap();
		System.out.println("Input coordinates:");
		String input;
		boolean hitResult = false;
		while (true) {
			input = scanner.nextLine();

			if (input.equals("q")) {
				break;

			} else if (input.equals("hint")) {
				board.printSubmarineMap();
				

			} else {
				try {
					hitResult = parseInput(input);
				} catch (OutOfBoardException e) {
					System.out.println(e.getMessage());
					continue;
				}
				if (hitResult) {
					guesses -= 1;

					if (board.allSubmarinesDetected()) {
						System.out.println("Congratulations!! You WIN!!!");
						break;
					} else if (guesses == 0 || points < 0) {
						System.out.println("GAME OVER");
						break;
					} else {
						printStats();
						board.printMap();
						System.out.println("Input coordinates:");
					}
				} else {
					System.out.println("WRONG INPUT, TRY AGAIN");
					
					//throw new OutOfBoardException();
					
				}
			}
		}

	}

	private boolean parseInput(String input) throws OutOfBoardException {
		int i = board.makeHit(input);
		if (i != 0) {
			points += i;
			return true;
		} else {
			return false;
		}
	}

	private void printStats() {
		System.out.println("\n\nYour Score: " + points + "   Guesses left: " + guesses);
	}

}
