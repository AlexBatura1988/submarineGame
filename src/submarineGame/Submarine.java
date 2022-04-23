package submarineGame;

import java.util.ArrayList;

public class Submarine {
	protected ArrayList<SubmarinePart> parts;

	public Submarine(ArrayList<Pair<Integer, Integer>> points) {
		this.parts = new ArrayList<>();
		for (Pair<Integer, Integer> point : points) {
			parts.add(new SubmarinePart(point));
		}
	}

	public void addPart(Pair<Integer, Integer> point) {
		parts.add(new SubmarinePart(point));
	}

	private static class SubmarinePart {
		Pair<Integer, Integer> point;

		public SubmarinePart(Pair<Integer, Integer> point) {
			this.point = point;
		}
	}

}
