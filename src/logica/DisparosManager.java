package logica;

import java.awt.Graphics;
import java.util.ArrayList;

import entities.Disparo;
import entities.Entidad;

public class DisparosManager {
	
	private ArrayList<Disparo> disparos;
	
	public DisparosManager() {
		disparos = new ArrayList<>();
	}
	
	public void add(int x, int y, int motion) {
		disparos.add(new Disparo(x, y, motion));
	}
	
	public void mover() {
		for(Disparo d : disparos) {
			d.mover();
		}
	}
	
	public void clearIfOffScreen() {
		for(int i = 0; i < disparos.size(); i++) {
			if(disparos.get(i).getPosY() < 0 || disparos.get(i).getPosY() + 5 > 590) {
				disparos.remove(i);
			}
		}
	}
	
	public boolean chequearColision(Entidad model) {
		for(int i = 0; i < disparos.size(); i++) {
			if(disparos.get(i).collidesWith(model)) {
				disparos.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics graphics, SpriteManager sm) {
		for(Disparo proj : disparos) {
			proj.draw(graphics, sm);
		}
	}
}
