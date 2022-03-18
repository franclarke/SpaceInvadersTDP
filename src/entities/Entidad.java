package entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import logica.SpriteManager;

public class Entidad {

	protected Rectangle hitbox;
	
	protected String sprite;
	
	public Entidad(String sprite, int x, int y, int w, int h) {
		hitbox = new Rectangle(x, y, w, h);
		this.sprite = sprite;
	}
	
	public int getPosX() {
		return hitbox.x;
	}
	
	public int getPosY() {
		return hitbox.y;
	}
	
	public int getWidth() {
		return hitbox.width;
	}
	
	public int getHeight() {
		return hitbox.height;
	}
	
	public boolean collidesWith(Entidad m) {
		return hitbox.intersects(m.hitbox);
	}
	
	public void draw(Graphics graphics, SpriteManager sm) {
		graphics.drawImage(sm.getSprite(sprite), hitbox.x, hitbox.y, hitbox.width, hitbox.height, null);
	}
	
	protected void draw(Graphics graphics, int uvx, int uvy, int uvw, int uvh, SpriteManager sm) {
		graphics.drawImage(sm.getSprite(sprite, uvx, uvy, uvw, uvh), hitbox.x, hitbox.y, hitbox.width, hitbox.height, null);
	}
}
