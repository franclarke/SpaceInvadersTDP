package entities;

import java.awt.Color;
import java.awt.Graphics;

import logica.SpriteManager;

public class Disparo extends Entidad {
	private int speed;
	
	public Disparo(int x, int y, int motion) {
		super("projectiles", x, y, 3, 15);
		this.speed = motion;
	}

	public void mover() {
		super.hitbox.y += speed * 3;
	}
	
	@Override
	public void draw(Graphics graphics, SpriteManager sm) {
		super.draw(graphics, sm);
		graphics.setColor(Color.WHITE);
		graphics.fillRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
	}
}
