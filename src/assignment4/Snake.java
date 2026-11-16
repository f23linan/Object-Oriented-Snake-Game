package assignment4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {

	private GameBoard gameBoard;
	private int currentWidth;
	private int currentHeight;
	private int squareSize;
	private List<Point> bodyParts;

	public Snake(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
		this.squareSize = gameBoard.getSquareSize();
		this.currentWidth = gameBoard.getStartWidth();
		this.currentHeight = gameBoard.getStartHeight();
		this.bodyParts = new ArrayList<>();
		bodyParts.add(new Point(currentWidth, currentHeight));
		bodyParts.add(new Point(currentWidth, currentHeight + squareSize));
	}

	// Draws the snake on the gameboard
	public void drawSnake(Graphics grid) {
		Color hexColor = Color.decode("#FF8599");
		grid.setColor(hexColor);

		for (Point bodyPart : bodyParts) {
			grid.fillRect(bodyPart.x, bodyPart.y, squareSize, squareSize);
			Color bodyColor = Color.decode("#BEDAC1");
			grid.setColor(bodyColor);
		}
	}

	// Adds a new bodypart at the end of the snake (used when a food has been eaten)
	public void addBodyPart() {
		Point newPart = bodyParts.get(bodyParts.size() - 1);
		bodyParts.add(new Point(newPart.x, newPart.y));
	}

	// Removes a bodypart at the end of the snake (used when a poison has been
	// eaten)
	public void removeBodyPart() {
		Point newPart = bodyParts.get(bodyParts.size() - 1);
		bodyParts.remove(new Point(newPart.x, newPart.y));
	}

	public int getCurrentWidth() {
		return currentWidth;
	}

	public int getCurrentHeight() {
		return currentHeight;
	}

	public int getSquareSize() {
		return squareSize;
	}

	// Updates the snake's current position
	public void setCurrentPosition(int width, int height) {
		this.currentWidth = width;
		this.currentHeight = height;
	}

	public List<Point> getBodyParts() {
		return bodyParts;
	}

	// Checks if the snake has collided with the gameboard boundaries
	public boolean checkBounds() {
		int boardWidth = gameBoard.getBoardWidth() * squareSize + 35;
		int boardHeight = gameBoard.getBoardHeight() * squareSize + 35;

		if (currentWidth < 35 || currentWidth >= boardWidth || currentHeight < 35 || currentHeight >= boardHeight) {
			return true;
		}
		return false;
	}

	// Checks if the snake has collided with itself
	private boolean checkSelfCollision() {
		Point head = bodyParts.get(0);

		for (int i = 1; i < bodyParts.size(); i++) {
			if (head.equals(bodyParts.get(i))) {
				return true;
			}
		}
		return false;
	}

	public boolean getSelfCollision() {
		return checkSelfCollision();
	}

}
