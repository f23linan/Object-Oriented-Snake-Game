package assignment4;

import java.awt.Color;
import java.awt.Graphics;

public class BadEdible extends Edibles {

	private ScoreBoard scoreBoard;

	// Constructor that initializes the scoreboard
	public BadEdible(ScoreBoard scoreBoard) {
		super();
		this.scoreBoard = scoreBoard;
	}

	// Draws a poison on the gameboard
	public void drawPoison(Graphics grid, GameBoard gameBoard) {
		Color hexColor = Color.decode("#637231");
		grid.setColor(hexColor);
		grid.fillOval(getPoisonWidth() + 8, getPoisonHeight() + 8, gameBoard.getSquareSize() / 2,
				gameBoard.getSquareSize() / 2);
	}

	// Checks if the poison has been eaten. If yes, spawns a new one
	public boolean eatenPoison(Snake snake) {

		// If-statement that checks if the snakes position is the same as the poison,
		// which means the poison has been eaten
		if (snake.getCurrentWidth() == this.getPoisonWidth() && snake.getCurrentHeight() == this.getPoisonHeight()) {
			spawnPoison();
			scoreBoard.loseScore();
			scoreBoard.getCurrentScoreLabel().setText("Current Score: " + scoreBoard.getCurrentScore());

			scoreBoard.revalidate();
			scoreBoard.repaint();
			snake.removeBodyPart();
			return true;
		}
		return false;
	}

}
