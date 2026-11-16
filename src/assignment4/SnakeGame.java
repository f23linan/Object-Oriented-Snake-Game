package assignment4;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SnakeGame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel gameBoard;
	private MoveSnake moveSnake;
	private ScoreBoard scoreBoard;
	private Snake snake;
	private Edibles edibles;
	private ShowMenus showMenus;

	// Entrypoint for the game, displays the main menu
	public static void main(String[] args) {
		SnakeGame snakeGame = new SnakeGame();
		snakeGame.showMenus = new ShowMenus(snakeGame);
		snakeGame.showMenus.showMainMenu();
	}

	// Initializes the main game window
	public SnakeGame() {
		setTitle("WORM");
		setLayout(new BorderLayout());
		setBounds(400, 100, 750, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Starts a new game based on the selected mode
	// Initializes the snake, scoreboard and movement-system
	public void startGame(String mode) {
		scoreBoard = new ScoreBoard();
		gameBoard = new GameBoard(scoreBoard, mode);
		snake = new Snake((GameBoard) gameBoard);
		((GameBoard) gameBoard).setSnakeHead(snake);
		moveSnake = new MoveSnake((GameBoard) gameBoard, snake, scoreBoard, this);
		edibles = new Edibles();

		// Refreshes UI with new game components
		getContentPane().removeAll();
		add(gameBoard, BorderLayout.CENTER);
		add(scoreBoard, BorderLayout.NORTH);

		// Set up key-controls
		keyStrokeHandling();

		revalidate();
		repaint();

		// Spawns food/poison based on the gameboard
		if (mode.equals("Expert")) {
			edibles.expertEdibles();
			edibles.normalEdibles();
		} else if (mode.equals("Normal")) {
			edibles.normalEdibles();
		}

		// Starts the game-loop
		Thread snakeThread = new Thread(moveSnake);
		snakeThread.start();
	}

	// Sets up keyboard controls the change the snake's direction
	public void keyStrokeHandling() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				if (keyCode == KeyEvent.VK_UP) {
					moveSnake.setDirection("UP");
				} else if (keyCode == KeyEvent.VK_DOWN) {
					moveSnake.setDirection("DOWN");
				} else if (keyCode == KeyEvent.VK_LEFT) {
					moveSnake.setDirection("LEFT");
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					moveSnake.setDirection("RIGHT");
				}
			}
		});
		setFocusable(true);
		requestFocusInWindow();
	}

	//Getters for the scoreBoard and menus
	public ScoreBoard getScoreBoard() {
		return this.scoreBoard;
	}

	public ShowMenus getShowMenus() {
		return this.showMenus;
	}
}
