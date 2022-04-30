package submarineGame;


public class Submarine {
	protected SubmarinePart[] parts;

	public Submarine(Point[] points) {
		this.parts = new SubmarinePart[points.length];
		for(int i = 0; i < points.length; i++) {
			if(points[i] != null) {
				parts[i] = new SubmarinePart(points[i]);
			}
		}
	}

	

	private static class SubmarinePart {
		Point point;

		public SubmarinePart(Point point) {
			this.point = point;
		}
	}

}
