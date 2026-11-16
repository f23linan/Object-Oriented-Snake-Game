package assignment4;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ShowMenus implements ActionListener {

	private SnakeGame snakeGame;

	public ShowMenus(SnakeGame snakeGame) {
		this.snakeGame = snakeGame;
	}

	// Draws out the main menu at the start of the game
	public void showMainMenu() {
		JPanel menuPanel = new MainMenu(this);
		snakeGame.getContentPane().removeAll();
		snakeGame.add(menuPanel, BorderLayout.CENTER);
		snakeGame.revalidate();
		snakeGame.repaint();
	}

	// Draws out the end menu at the end of the game, depending on if you won or
	// lost
	public void showEndMenu() {
		EndMenu endMenu = new EndMenu();
		ScoreBoard scoreBoard = snakeGame.getScoreBoard();
		if (scoreBoard.getCurrentScore() == 25) {
			endMenu.win(this);
		} else {
			endMenu.lost(this);
		}

		snakeGame.getContentPane().removeAll();
		snakeGame.add(endMenu, BorderLayout.CENTER);
		snakeGame.revalidate();
		snakeGame.repaint();
	}

	// Starts either normal or expert mode, depending on which one has been chosen
	// in either the main menu or end menu
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();

		switch (command) {
		case "Normal mode":
			snakeGame.startGame("Normal");
			break;
		case "Expert mode":
			snakeGame.startGame("Expert");
			break;
		default:
			System.out.println("Unknown command");
			break;
		}
	}

}
