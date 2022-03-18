package main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import logica.Logica;
import states.Context;


public class GUI extends JPanel implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private Context states;
	private Logica logica;

	public GUI() {

		states = new Context();
		logica = new Logica(states);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Lo llama Timer en la clase Main
		states.loop();
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		states.draw(g,logica.getSM());
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		states.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		states.keyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}