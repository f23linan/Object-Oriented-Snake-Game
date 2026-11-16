package assignment4;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {

	private int currentScore;

	private JLabel currentScoreLabel;
	private static final long serialVersionUID = 1L;

	// Initializes the scoreboard with a white background and a green grid, along
	// with the score label
	public ScoreBoard() {

		// Sets color of grid
		Color boardColor = Color.decode("#08800A");
		setBackground(boardColor);

		// Initializes and formats the score label
		currentScoreLabel = new JLabel("Current Score:" + currentScore);
		currentScoreLabel.setBounds(20, 10, 250, 30);
		currentScoreLabel.setForeground(Color.WHITE);

		add(currentScoreLabel);

		revalidate();
		repaint();
	}

	// Getter for currentscore
	public int getCurrentScore() {
		return currentScore;
	}

	// Getter that removes one point from the current score
	public int loseScore() {
		return currentScore--;
	}

	// Getter that adds one point to the current score
	public int gainScore() {
		return currentScore++;
	}

	// Getter for the score label
	public JLabel getCurrentScoreLabel() {
		return currentScoreLabel;
	}

}
