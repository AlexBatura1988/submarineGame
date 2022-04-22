package submarineGame;

import java.util.ArrayList;
import java.util.HashMap;

public class Submarine {
	protected ArrayList<SubmarinePart> parts;
	public Submarine(ArrayList<HashMap<Integer, Integer>> points) {
           this.parts = new ArrayList<>();
           for(HashMap<Integer, Integer> point : points) {
        	   parts.add(new SubmarinePart(point));
           }
	}
	
	public void addPart(HashMap<Integer, Integer> point) {
		parts.add(new SubmarinePart(point));
	}
	
	
	

	private static class SubmarinePart {
		HashMap<Integer, Integer> point;


		public SubmarinePart(HashMap<Integer, Integer> point) {
			this.point = point;
		}
	}

}
