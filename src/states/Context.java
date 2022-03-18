package states;

import java.awt.Graphics;

import logica.SpriteManager;

public class Context {

	private State state;
	
	public Context() {
		state = new MenuState(this);
	}
	
	public void changeState(State newState) {
		state= newState;
	}

	public void loop() {
		state.loop();
	}
	
	public void draw(Graphics g, SpriteManager sm) {
		state.draw(g,sm);
	}
	
	public void keyPressed(int keyCode) {
		state.keyPressed(keyCode);
	}
	
	public void keyReleased(int keyCode) {
		state.keyReleased(keyCode);
	}
}
