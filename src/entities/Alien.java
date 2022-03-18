package entities;

import java.awt.Graphics;

import logica.DisparosManager;
import logica.SpriteManager;

public class Alien extends Entidad {

	private Tipo tipo;
	private int animation;
	private int deathTime;
	private int deathDelay;
	
	public Alien(int x, int y, Tipo tipo) {
		super("aliens", x, y, 36, 24);
		this.tipo = tipo;
		this.animation = 0;
		this.deathTime = -1;
		this.deathDelay = 20;
	}
	
	public Tipo getType() {
		return tipo;
	}
	
	public boolean isDead() {
		return deathTime == deathDelay;
	}
	
	public void die() {
		this.deathTime = 0;
	}
	
	public void changeAnimation() {
		this.animation = (1 - this.animation);
	}
	
	public void updateDeathAnimation() {
		if(deathTime >= 0 && deathTime < deathDelay)
			this.deathTime++;
	}
	
	public void move(int x, int y) {
		super.hitbox.x += x;
		super.hitbox.y += y;
	}
	
	public void shoot(DisparosManager disparosManager) {
		disparosManager.add(hitbox.x + hitbox.width / 2, hitbox.y + hitbox.height, 2);
	}
	
	@Override
	public void draw(Graphics graphics, SpriteManager sm) {
		if(deathTime < 0) 
			draw(graphics, 12 * animation, 8 * tipo.index, 12, 8, sm);
		else 
			draw(graphics, 12 * animation, 8 * 3, 12, 8, sm);
	}

	public enum Tipo {
		ALIEN1(0),
		ALIEN2(1),
		ALIEN3(2);
		
		public int index;
		
		Tipo(int index) {
			this.index = (int) index;
		}
	}
}
