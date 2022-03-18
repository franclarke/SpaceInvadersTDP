package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import logica.SpriteManager;


public class GameOverState extends State {

	private int score;

	public GameOverState(Context context, int score) {
		super(context);
		this.score = score;
	}

	@Override
	public void loop() {}

	@Override
	public void draw(Graphics graphics, SpriteManager sm) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 800, 650);

		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Arial", Font.BOLD, 66));
		graphics.drawString("GAME", 150, 120);
		graphics.setColor(Color.RED);
		graphics.drawString("OVER", 420, 120);

		graphics.setFont(new Font("Arial", Font.PLAIN, 25));
		graphics.setColor(Color.WHITE);
		graphics.drawString("Puntaje: " + score,320, 300);
		graphics.drawString("Presiona ESCAPE o ENTER para volver", 170, 400);
		graphics.drawString("al menu princial", 300, 450);

	}

	@Override
	public void keyPressed(int keyCode) {
		if(keyCode == KeyEvent.VK_ESCAPE || keyCode == KeyEvent.VK_ENTER) {
			context.changeState(new MenuState(context));
		}
	}

	@Override
	public void keyReleased(int keyCode) {}


}
