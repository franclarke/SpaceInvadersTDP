package states;

import java.awt.Graphics;

import logica.SpriteManager;

public abstract class State {

	protected Context context;
	
	public State(Context context) {
		this.context = context;
	}
	
	public abstract void loop();
	
	public abstract void keyPressed(int keyCode);

	public abstract void keyReleased(int keyCode);

	public void draw(Graphics graphics, SpriteManager sm) {
		
	}
}
