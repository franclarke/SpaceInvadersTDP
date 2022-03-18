package main;
import java.awt.Dimension;

import javax.swing.JFrame;

public class WindowManager {

	
	private final JFrame window;
	
	public WindowManager(GUI gui) {
		window = new JFrame("Space Invaders");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setBounds(0,0, 800, 680);
		window.setLocationRelativeTo(gui);
		gui.setPreferredSize(new Dimension(800,700));
		
		gui.setFocusable(true);
		gui.addKeyListener(gui);
		
		window.setContentPane(gui);
		window.setVisible(true);
		
		gui.requestFocusInWindow();
		
	}
}