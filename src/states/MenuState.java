package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import logica.SpriteManager;

public class MenuState extends State {


	public MenuState(Context context) {
		super(context);
	}

	@Override
	public void loop() {}

	@Override
	public void draw(Graphics graphics, SpriteManager sm) {

		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 800, 650);

		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("Arial", Font.BOLD, 66));
		graphics.drawString("SPACE", 90, 120);
		graphics.setColor(Color.GREEN);
		graphics.drawString("INVADERS", 360, 120);

		graphics.setFont(new Font("Arial", Font.PLAIN, 25));

		graphics.setColor(Color.WHITE);
		graphics.drawString("Presiona ENTER para comenzar a jugar", 170, 270);


		graphics.drawImage(sm.getSprite("aliens", 0, 0, 12, 8), 300, 380, 35, 25, null);
		graphics.drawImage(sm.getSprite("aliens", 0, 8, 12, 8), 300, 430, 35, 25, null);
		graphics.drawImage(sm.getSprite("aliens", 0, 16, 12, 8), 300, 475, 35, 25, null);
		graphics.setColor(Color.WHITE);
		graphics.drawString("= 10 points", 340, 400);
		graphics.drawString("= 20 points", 340, 450);
		graphics.drawString("= 30 points", 340, 500);
	}

	@Override
	public void keyPressed(int keyCode) {
		if(keyCode == KeyEvent.VK_ENTER)
			context.changeState(new PlayingState(context));
		else if(keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(int keyCode) {}


}
