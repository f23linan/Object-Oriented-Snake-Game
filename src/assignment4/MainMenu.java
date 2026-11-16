package assignment4;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton buttonNormal;
	private JButton buttonExpert;

	public MainMenu(ActionListener listener) {

		// Creates and configures a button for normal mode
		buttonNormal = new JButton("Normal mode");
		buttonNormal.setActionCommand("Normal mode");
		buttonNormal.addActionListener(listener);

		// Creates and configures a button for expert mode
		buttonExpert = new JButton("Expert mode");
		buttonExpert.setActionCommand("Expert mode");
		buttonExpert.addActionListener(listener);

		// Adds the buttons to the JPanel
		add(buttonNormal);
		add(buttonExpert);
	}
}
