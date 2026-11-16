package assignment4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GameBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	private static int squareSize = 35;
	private int boardWidth = 19;
	private int boardHeight = 11;

	private JPanel gameBoard;
	private Edibles edibles;
	private GoodEdible goodEdible;
	private BadEdible badEdible;
	private ScoreBoard scoreBoard;
	private Snake snake;
	private String mode;

	private int startWidth = ((boardWidth / 2) * squareSize) + 35;
	private int startHeight = ((boardHeight / 2) * squareSize) + 35;

	// Constructor for gameboard
	// Initializes game-elements and spawns food/poison based on the mode
	public GameBoard(ScoreBoard scoreBoard, String mode) {
		this.snake = new Snake(this);
		this.edibles = new Edibles();
		this.scoreBoard = scoreBoard;
		this.mode = mode;
		gameBoard = new JPanel();
		goodEdible = new GoodEdible(scoreBoard);
		badEdible = new BadEdible(scoreBoard);

		// Spawns food and poison based on the mode
		if (mode.equals("Normal")) {
			goodEdible.spawnFood();
		} else if (mode.equals("Expert")) {
			badEdible.spawnPoison();
			goodEdible.spawnFood();

		}
	}

	public void setSnakeHead(Snake snake) {
		this.snake = snake;
	}

	// Draws the gameboard, grid, food, poison and the snake
	public void paint(Graphics grid) {
		super.paint(grid);

		Color gridColor = Color.decode("#64A66B");
		grid.setColor(gridColor);

		// Draws the grid
		for (int x = 35; x <= 675; x += 35)
			for (int y = 35; y <= 400; y += 35)
				grid.drawRect(x, y, 35, 35);

		// Draws food and poison based on game-mode
		if (mode.equals("Expert")) {
			badEdible.drawPoison(grid, this);
			goodEdible.drawFood(grid, this);
		} else if (mode.equals("Normal")) {
			goodEdible.drawFood(grid, this);
		}

		// Checks if food has been eaten, and then re-spawns it
		if (goodEdible.eatenFood(snake)) {
			edibles.spawnFood();
		}

		// Checks if poison has been eaten, and then re-spawns it
		if (badEdible.eatenPoison(snake)) {
			edibles.spawnPoison();
		}

		// Draws the snake
		snake.drawSnake(grid);
		gameBoard.revalidate();
		gameBoard.repaint();
	}

	// Get all the information about the start height, width, and the size of a
	// square in the grid
	public int getSquareSize() {
		return squareSize;
	}

	public int getStartWidth() {
		return startWidth;
	}

	public int getStartHeight() {
		return startHeight;
	}

	public void setStartWidth(int width) {
		startWidth = width;
	}

	public void setStartHeight(int height) {
		startHeight = height;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

}
