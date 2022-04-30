package submarineGame;

public class Point {

	private int first;
	private int second;

	public Point(int first, int second) {
		this.first = first;
		this.second = second;
	}

	public int getFirst() {
		return first;
	}

	public int getSecond() {
		return second;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return first == other.first && second == other.second;
	}

}
