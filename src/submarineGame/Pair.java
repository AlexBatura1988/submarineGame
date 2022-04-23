package submarineGame;

public class Pair<U, V> {

	public U first;
	public V second;

	public Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Pair<?, ?> pair = (Pair<?, ?>) o;

		if (!first.equals(pair.first)) {
			return false;
		}
		return second.equals(pair.second);
	}

}
