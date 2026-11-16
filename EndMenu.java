package assignment4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton buttonNormal;
	private JButton buttonExpert;
	private JLabel lostLabel, winLabel;

	// Displays the lost-screen with a retry message, and mode selection buttons
	public void lost(ActionListener listener) {
		setLayout(new BorderLayout());

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		lostLabel = new JLabel("You died! Try again?");
		labelPanel.add(lostLabel, BorderLayout.NORTH);
		add(labelPanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// Adds button for normal mode
		buttonNormal = new JButton("Normal mode");
		buttonNormal.setActionCommand("Normal mode");
		buttonNormal.addActionListener(listener);

		// Adds button for expert mode
		buttonExpert = new JButton("Expert mode");
		buttonExpert.setActionCommand("Expert mode");
		buttonExpert.addActionListener(listener);

		buttonPanel.add(buttonNormal);
		buttonPanel.add(buttonExpert);

		add(buttonPanel, BorderLayout.CENTER);

	}

	// Displays the win-screen with a success message, and mode selection buttons
	public void win(ActionListener listener) {
		setLayout(new BorderLayout());

		JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		winLabel = new JLabel("You got a score of 25 AND WON! Try again?");
		labelPanel.add(winLabel, BorderLayout.NORTH);
		add(labelPanel, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// Adds buttons for normal mode
		buttonNormal = new JButton("Normal mode");
		buttonNormal.setActionCommand("Normal mode");
		buttonNormal.addActionListener(listener);

		// Adds buttons for expert mode
		buttonExpert = new JButton("Expert mode");
		buttonExpert.setActionCommand("Expert mode");
		buttonExpert.addActionListener(listener);

		buttonPanel.add(buttonNormal);
		buttonPanel.add(buttonExpert);

		add(buttonPanel, BorderLayout.CENTER);
	}

}
