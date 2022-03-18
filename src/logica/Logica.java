package logica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import states.Context;

public class Logica  implements ActionListener, KeyListener {

	private final Context context;
	SpriteManager sm;
	JPanel jp;

	public Logica(Context c) {
		sm = new SpriteManager();
		sm.readSprites();
		context = c;
		;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		context.loop();
	}

	public Context getContext() {
		return context;
	}

	public SpriteManager getSM() {
		return sm;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		context.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		context.keyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}
