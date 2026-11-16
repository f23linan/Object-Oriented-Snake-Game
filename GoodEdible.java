package assignment4;

import java.awt.Color;
import java.awt.Graphics;

public class GoodEdible extends Edibles {

	private ScoreBoard scoreBoard;

	// Constructor that initializes the scoreboard
	public GoodEdible(ScoreBoard scoreBoard) {
		super();
		this.scoreBoard = scoreBoard;
	}

	// Draws a food on the gameboard
	public void drawFood(Graphics grid, GameBoard gameBoard) {
		Color hexColor = Color.decode("#FFC0CB");
		grid.setColor(hexColor);
		grid.fillOval(getFoodWidth() + 8, getFoodHeight() + 8, gameBoard.getSquareSize() / 2,
				gameBoard.getSquareSize() / 2);
	}

	// Checks if the food has been eaten. If yes, spawns a new one
	public boolean eatenFood(Snake snake) {

		// If-statement that checks if the snake's position is the same as the food's,
		// which means it has been eaten
		if (snake.getCurrentWidth() == this.getFoodWidth() && snake.getCurrentHeight() == this.getFoodHeight()) {
			spawnFood();
			scoreBoard.gainScore();
			scoreBoard.getCurrentScoreLabel().setText("Current Score: " + scoreBoard.getCurrentScore());

			scoreBoard.revalidate();
			scoreBoard.repaint();
			snake.addBodyPart();

			return true;
		}
		return false;
	}
}
