package assignment4;

import java.awt.Point;

public class MoveSnake implements Runnable {

	private GameBoard gameBoard;
	private Snake snake;
	private boolean autoMoving;
	private String snakeDirection;
	private ScoreBoard scoreBoard;
	private SnakeGame snakeGame;

	public MoveSnake(GameBoard gameBoard, Snake snake, ScoreBoard scoreBoard, SnakeGame snakeGame) {
		this.gameBoard = gameBoard;
		this.snake = snake;
		this.autoMoving = true;
		this.snakeDirection = "UP";
		this.scoreBoard = scoreBoard;
		this.snakeGame = snakeGame;
	}

	// Moves the snake in the current direction and handles collisions
	// If the snake eats food or poison, updates the game state
	public void moveSnake() {
		int squareSize = snake.getSquareSize();
		int currentWidth = snake.getCurrentWidth();
		int currentHeight = snake.getCurrentHeight();

		// Determines the new position based on the snake's direction, while also
		// preventing reversing directions
		if (snakeDirection.equals("UP")) {
			if (!snakeDirection.equals("DOWN")) {
				currentHeight -= squareSize;
			}
		} else if (snakeDirection.equals("DOWN")) {
			if (!snakeDirection.equals("UP")) {
				currentHeight += squareSize;
			}
		} else if (snakeDirection.equals("LEFT")) {
			if (!snakeDirection.equals("RIGHT")) {
				currentWidth -= squareSize;
			}
		} else if (snakeDirection.equals("RIGHT")) {
			if (!snakeDirection.equals("LEFT")) {
				currentWidth += squareSize;
			}
		}

		// Moves each bodypart to the position of the previous one
		for (int i = snake.getBodyParts().size() - 1; i > 0; i--) {
			Point current = snake.getBodyParts().get(i);
			Point previous = snake.getBodyParts().get(i - 1);
			current.setLocation(previous);
		}

		if (snake.getBodyParts().size() == 0) {
			System.out.println("FAIL");
		}

		// Move the snake head to the new position
		snake.getBodyParts().get(0).setLocation(currentWidth, currentHeight);
		snake.setCurrentPosition(currentWidth, currentHeight);

		// Checks for game-ending conditions
		if (snake.getSelfCollision() || snake.checkBounds() || scoreBoard.getCurrentScore() == 25
				|| scoreBoard.getCurrentScore() < 0) {

			autoMoving = false; // Stops movement
			snakeGame.getShowMenus().showEndMenu(); // Displays the end-menu

		}
	}

	// Updates the snake's movement direction, while preventing 180-degree reversals
	public void setDirection(String newDirection) {
		if ((snakeDirection.equals("UP") && newDirection.equals("DOWN"))
				|| (snakeDirection.equals("DOWN") && newDirection.equals("UP"))
				|| (snakeDirection.equals("LEFT") && newDirection.equals("RIGHT"))
				|| (snakeDirection.equals("RIGHT") && newDirection.equals("LEFT"))) {
			return;
		}
		this.snakeDirection = newDirection;
	}

	// Runs the automatic movement of the snake in a loop
	// The snake moves every 325 ms, until the game ends
	@Override
	public void run() {
		while (autoMoving) {
			try {

				// Controls the snake's speed
				Thread.sleep(325);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Updates snake's position
			moveSnake();
			gameBoard.revalidate();
			gameBoard.repaint();
		}
	}

}
