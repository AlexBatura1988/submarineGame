package submarineGame;

public class Runner {

	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game(board);
		game.run();

	}

}
