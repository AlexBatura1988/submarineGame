package submarineGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Board {
	private static final char FREE_POINT = '.';
	private static final char SUBMARINE = 'X';
	protected char[] letters;
	protected Submarine[] submarines;
	protected char[][] map;
	protected char[][] mapWithSubmarines;
	private boolean consecutiveHit = false;

	public Board() {
		map = new char[10][20];
		mapWithSubmarines = new char[10][20];
		submarines = new Submarine[5];
		letters = "ABCDRFGHIJ".toCharArray();

		initMaps();

	}

	protected void initMaps() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 20; j++) {
				map[i][j] = FREE_POINT;
				mapWithSubmarines[i][j] = FREE_POINT;
			}
		}
		for (int i = 0; i < 5; i++) {
			submarines[i] = createSubmarine();
		}
	}

	public void printMap() {
		System.out.println("  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		for (int i = 0; i < 10; i++) {
			System.out.print(letters[i] + " ");
			for (int j = 0; j < 20; j++) {
				System.out.print(map[i][j] + "  ");

			}
			System.out.println();
		}
	}

	public void printSubmarineMap() {
		System.out.println("  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20");
		for (int i = 0; i < 10; i++) {
			System.out.print(letters[i] + " ");
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
		Point[] submarinePointsList = new Point[1];
		do {
			x = (int) (Math.random() * 10);
			y = (int) (Math.random() * 20);
		} while (!checkFreePoint(x, y, null));
		mapWithSubmarines[x][y] = SUBMARINE;
		submarinePointsList[0] = new Point(x, y);

		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			if (random.nextBoolean()) {
				int nextX, nextY, counter = 0;
				do {
					if (random.nextBoolean()) {
						nextX = x + (1 - ((int) (Math.random() * 3)));
						nextY = y;
					} else {
						nextY = y + (1 - ((int) (Math.random() * 3)));
						nextX = x;
					}

					// checking if x is in range 1..10, y in 1..20 and its not already placed
				} while (((nextX < 0 || nextX >= 10) || (nextY < 0 || nextY >= 20))
						|| arrayContains(submarinePointsList, new Point(nextX, nextY)));

				if (checkFreePoint(nextX, nextY, submarinePointsList)) {
					mapWithSubmarines[nextX][nextY] = SUBMARINE;
					Point[] updateList = new Point[submarinePointsList.length + 1];
					int index = 0;
					for (Point point : submarinePointsList) {
						updateList[index++] = point;
					}
					updateList[index] = new Point(nextX, nextY);
					submarinePointsList = updateList;
					x = nextX;
					y = nextY;
				}
			}
		}
		return new Submarine(submarinePointsList);
	}

	private boolean arrayContains(Point[] points, Point point) {
		for (Point pointFromList : points) {
			if (pointFromList.equals(point)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkFreePoint(int x, int y, Point[] submarinePointsList) {
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
						if (!arrayContains(submarinePointsList, new Point(xi, yj))) {
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

	public int makeHit(String input) {
		int x;
		int y;
		try {
			x = indexOf(letters, input.toUpperCase().charAt(0));
			y = Integer.parseInt(input.substring(1)) - 1;

		} catch (Exception e) {
			return 0;
		}
		if (x < 0 || y < 0 || y > 19) {
			return 0;
		}
		if (mapWithSubmarines[x][y] == SUBMARINE) {
			map[x][y] = 'H';
			for (Submarine submarine : submarines) {
				if (submarine.detect(x, y)) {
					if (submarine.isDetected()) {
						surroundSubmarine(submarine);
					}

				}
			}

			if (consecutiveHit) {
				return 1000;
			} else {
				consecutiveHit = true;
				return 200;
			}
		} else {
			map[x][y] = 'm';
			consecutiveHit = false;
			return -10;
		}
	}

	private void surroundSubmarine(Submarine submarine) {
		for (Point point : submarine.getPoints()) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int xi = point.getX() + i;
					int yj = point.getY() + j;
					if (xi >= 0 && xi < 10 && yj >= 0 && yj < 20) {
						if (map[xi][yj] == '.')
							map[xi][yj] = 'O';
					}
				}
			}
		}

	}

	private int indexOf(char[] chars, char c) {
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == c) {
				return i;
			}
		}
		return -1;
	}
}
