package submarineGame;

public class OutOfBoardException extends Exception {
	
	public OutOfBoardException() {
		super("x or y coordinates are not inside the board limit, try again");
	}

}
