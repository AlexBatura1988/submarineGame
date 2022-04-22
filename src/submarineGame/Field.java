package submarineGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Field {
	private static final char FREE_POINT = '.';
	private static final char SUBMARINE = 'X';
	protected ArrayList<Character> letters;
	protected char[][] map;
	protected char[][] mapWithSubmarines;

	public Field() {
		map = new char[10][20];
		mapWithSubmarines = new char[10][20];
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
		initMaps();

	}

	protected void initMaps() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				map[i][j] = FREE_POINT;
				mapWithSubmarines[i][j] = FREE_POINT;
			}
		}
	}

	public void printMap() {
		System.out.println("  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		for (int i = 0; i < 10; i++) {
			System.out.print(letters.get(i) + " ");
			for (int j = 0; j < 20; j++) {
				System.out.print(map[i][j] + "  ");

			}
			System.out.println();
		}
	}

	public void printSubmarineMap() {
		System.out.println("  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		for (int i = 0; i < 10; i++) {
			System.out.print(letters.get(i) + " ");
			for (int j = 0; j < 20; j++) {
				System.out.print(mapWithSubmarines[i][j] + "  ");

			}
			System.out.println();
		}
	}

	public Submarine createSubmarine() {
		// put first one cell submarine
		int x;
		int y;
		ArrayList<HashMap<Integer, Integer>> submarinePointList = new ArrayList<>();
		do {
			x = (int) (Math.random() * 10);
			y = (int) (Math.random() * 20);
		}while(!checkFreePoint(x, y, null));
		mapWithSubmarines[x][y] = SUBMARINE;
		submarinePointList.add(new HashMap<>(x, y));
		return new Submarine(submarinePointList);
	}

	private boolean checkFreePoint(int x, int y, ArrayList<HashMap<Integer, Integer>> submarinePointsList) {
		char point = mapWithSubmarines[x][y];
		if (point != FREE_POINT) {
			return false;
		}
		// checking nearby fields
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				int xi = x + i;
				int yj = y + j;
				if (xi >= 0 && xi < 10 && yj >= 0 && yj < 20) {
					if (submarinePointsList != null) {
						if (!submarinePointsList.contains(new HashMap<>(xi, yj))) {
							if (mapWithSubmarines[xi][yj] != FREE_POINT)
								return false;
						}
					} else {
						if (mapWithSubmarines[xi][yj] != FREE_POINT)
							return false;
					}
				}
			}
		}

		return true;
	}
}
