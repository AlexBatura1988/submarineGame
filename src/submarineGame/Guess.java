package submarineGame;

public class Guess {
	private int x;
	private int y;
	private int guessNumber;
	
	 @Override
	    public String toString() {
	        return guessNumber + "_" + x + "_" + y + "\n";
	    }
	 
	 public static Guess fromString(String lineFromFile) {
	        Guess guess = new Guess();
	        guess.guessNumber = Integer.parseInt(lineFromFile.split("_")[0]);
	        guess.x = Integer.parseInt(lineFromFile.split("_")[1]);
	        guess.y = Integer.parseInt(lineFromFile.split("_")[2]);
	        return guess;
	    }

	    public String toInputFormat() {
	        return String.valueOf(Board.LETTERS[x]) + (y+1);
	    }

}
