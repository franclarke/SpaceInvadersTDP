package entities;

import java.awt.Graphics;

import logica.DisparosManager;
import logica.SpriteManager;

public class Nave extends Entidad {
	
	private boolean left;
	private boolean right;
	
	private int shootTime;
	private int shootDelay;
	
	//Lives
	private int vidas;

	private int deathTime;
	private int deathDelay;
	
	public Nave() {
		super("player", 400, 590 - 25, 40, 25);
		left = false;
		right = false;
		shootTime = 0;
		shootDelay = 20;
		vidas = 3;
		deathTime = -1;
		deathDelay = 25;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}
	
	public void setRight(boolean right) {
		this.right = right;
	}
	
	public int getLives() {
		return vidas;
	}
	
	public void move() {
		if(deathTime < 0) {
			if(left && hitbox.x > 45) super.hitbox.x -= 1 * 3;
			if(right && hitbox.x + hitbox.width < 755) super.hitbox.x += 1 * 3;
		}
	}
	
	public void adjustDelay() {
		if(shootTime < shootDelay)
			shootTime++;
		
		if(deathTime >= 0 && deathTime < deathDelay)
			deathTime++;
		else
			deathTime = -1;
	}
	
	public void disparo(DisparosManager disparosManager) {
		if(shootTime == shootDelay && deathTime < 0) {
			disparosManager.add(hitbox.x + hitbox.width / 2, hitbox.y - hitbox.height, -3);
			shootTime = 0;
		}
	}
	
	public void checkCollision(DisparosManager disparosManager) {
		if(disparosManager.chequearColision(this)) {
			vidas--;
			deathTime = 0;
		}
	}
	
	public boolean isDying() {
		return deathTime >= 0;
	}
	
	@Override
	public void draw(Graphics graphics, SpriteManager sm) {
		if(deathTime < 0) //Nave viva, dibujar normal
			super.draw(graphics, 0, 0, 13, 8, sm);
		else if(deathTime % 2 == 0) //Nave muerta, dibujar animacion muerte (frame 0)
			super.draw(graphics, 13, 0, 13, 8, sm);
		else //Nave muerta, dibujar animacion muerte (frame 1)
			super.draw(graphics, 13 * 2, 0, 13, 8, sm);
	}
}
