package submarineGame;

import java.util.ArrayList;

public class Field {
	private static final char  FREE_POINT = '.';
	protected ArrayList<Character> letters;
	protected char[][] map;

	public Field() {
		letters = new ArrayList<Character>() {
			{
				add('A');
				add('B');
				add('C');
				add('D');
				add('E');
				add('F');
				add('G');
				add('H');
				add('I');
				add('J');

			}
		};
		map = new char[10][20];

	}

	public void printMap() {
		System.out.println("  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		for (int i = 0; i < 10; i++) {
			System.out.print(letters.get(i) + " ");
			for (int j = 0; j < 20; j++) {
				map[i][j] = FREE_POINT;
				System.out.print(map[i][j] + "  ");

			}
			System.out.println();
		}

	}
}
