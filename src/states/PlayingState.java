package states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import entities.Nave;
import logica.AlienManager;
import logica.DisparosManager;
import logica.SpriteManager;

public class PlayingState extends State {

	private Nave nave;
	private AlienManager aliens;
	private DisparosManager disparos;
	private Random random;

	public PlayingState(Context context) {
		super(context);
		nave = new Nave();
		aliens = new AlienManager();
		disparos = new DisparosManager();
		random = new Random();
	}



	@Override
	public void loop() {
		nave.move();
		nave.adjustDelay();
		nave.checkCollision(disparos);


		if(!nave.isDying()) {
			aliens.mover();
			aliens.disparar(random, disparos);
			aliens.chequearColision(disparos);

			disparos.mover();
			disparos.clearIfOffScreen();
			if(nave.getLives() == 0 || aliens.aterrizo()) {
				context.changeState(new GameOverState(context, aliens.getPuntaje()));
			}
		}
	}

	@Override
	public void draw(Graphics graphics, SpriteManager sm) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(0, 0, 800, 650);

		graphics.setColor(Color.GREEN);
		graphics.fillRect(45, 590 + 15, 800 - 2 * 45, 3);

		graphics.setColor(Color.WHITE);
		graphics.setFont(new Font("arial", Font.BOLD, 25));
		graphics.drawString("Score: " + aliens.getPuntaje(), 45, 635);
		graphics.drawString("Lives: ", 45 + 225, 635);

		for(int i = 0; i < nave.getLives(); i++) {
			graphics.drawImage(sm.getSprite("player", 0, 0, 13,8), 45 + (100 + i * 10) * 3, 620, 20, 12, null);
		}
		nave.draw(graphics,sm);
		aliens.draw(graphics, sm);
		disparos.draw(graphics, sm);
	}

	@Override
	public void keyPressed(int keyCode) {
		if(keyCode == KeyEvent.VK_LEFT) {
			nave.setLeft(true);
		}
		else if(keyCode == KeyEvent.VK_RIGHT) {
			nave.setRight(true);
		}
		else if(keyCode == KeyEvent.VK_SPACE) {
			nave.disparo(disparos);
		}
		else if(keyCode == KeyEvent.VK_ESCAPE) {
			context.changeState(new MenuState(context));
		}
	}

	@Override
	public void keyReleased(int keyCode) {
		if(keyCode == KeyEvent.VK_LEFT) {
			nave.setLeft(false);
		}
		else if(keyCode == KeyEvent.VK_RIGHT) {
			nave.setRight(false);
		}
	}

}
