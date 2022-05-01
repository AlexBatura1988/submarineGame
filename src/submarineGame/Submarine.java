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
	
	public Point[] getPoints() {
        Point[] points = new Point[parts.length];
        for (int i = 0; i < parts.length; i++) {
            points[i] = parts[i].point;
        }
        return points;
    }
	
	public boolean detect(int x, int y) {
        for (SubmarinePart part: parts) {
            if(part.point.getX() == x && part.point.getY() == y) {
                part.detected = true;
                return true;
            }
        }
        return false;
    }
	 public boolean isDetected() {
	        for (SubmarinePart part: parts) {
	            if(!part.detected) {
	                return false;
	            }
	        }
	        return true;
	    }

	

	private static class SubmarinePart {
		Point point;
		boolean detected;

		public SubmarinePart(Point point) {
			this.point = point;
		}
	}

}
