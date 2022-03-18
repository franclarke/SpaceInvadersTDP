package logica;

import java.awt.Graphics;
import java.util.Random;

import entities.Alien;

public class AlienManager{

	public  Alien[][] aliens;

	private int motionX = 25;
	private int motionY = 25;

	private int moveDelay = 10;
	private int moveTime = 0;

	private int shootDelay = 30;
	private int shotTime = 0;

	private int puntaje = 0;

	private int muertos = 0;

	public AlienManager() {
		aliens = new Alien[5][11];
		resetear();
		
	}

	private void resetear() {
		for(int i = 0; i < aliens.length; i++) {
			for(int j = 0; j < aliens[i].length; j++) {
				if(i == 0)
					aliens[i][j] = new Alien(45 + j * 50, 90 + i * 40, Alien.Tipo.ALIEN1);
				else if(i == 1 || i == 2)
					aliens[i][j] = new Alien(45 + j * 50, 90 + i * 40, Alien.Tipo.ALIEN2);
				else
					aliens[i][j] = new Alien(45 + j * 50, 90 + i * 40, Alien.Tipo.ALIEN3);
			}
		}
	}

	public void mover() {
		moveTime++; 
		if(moveTime >= moveDelay) {
			moverTodos(); 
			moveTime = 0; 

			if(aliens[4][10].getPosX() + aliens[4][10].getWidth() > 770 || aliens[0][0].getPosX() < 45) {
				bajar();
				motionX = -motionX;
			}
		}
	}

	private void moverTodos() {
		for(int i = 0; i < aliens.length; i++) {
			for(int j = 0; j < aliens[i].length; j++) {
				aliens[i][j].changeAnimation();
				aliens[i][j].move(motionX, 0);
			}
		}
	}

	private void bajar() {
		for(int i = 0; i < aliens.length; i++) {
			for(int j = 0; j < aliens[i].length; j++) {
				aliens[i][j].move(0, motionY);
			}
		}
	}

	public void disparar(Random random, DisparosManager dm) {
		if(shotTime < shootDelay) {
			shotTime++;
		} else {
			elegirDisparador(random, dm);
			shootDelay = random.nextInt(30) + 10;
			shotTime = 0;
		}
	}

	private void elegirDisparador(Random random, DisparosManager dm) {
		//Elige un alien random
		int choiceI = random.nextInt(5);
		int choiceJ = random.nextInt(11);

		//Si el alien es el ultimo de la fila o el ultimo vivo de la fila, dispara
		if(choiceI == 4) {
			if(!aliens[choiceI][choiceJ].isDead())
				aliens[choiceI][choiceJ].shoot(dm);
		}
		else {
			if(aliens[choiceI+1][choiceJ].isDead() && !aliens[choiceI][choiceJ].isDead()) {
				aliens[choiceI][choiceJ].shoot(dm);
			}
			else {
				//Si no puede disparar, elige otro
				elegirDisparador(random, dm);
			}
		}
	}

	public void chequearColision(DisparosManager disparosManager) {
		for(int i = 0; i < aliens.length; i++) {
			for(int j = 0; j < aliens[i].length; j++) {
				if(!aliens[i][j].isDead()) {
					if(disparosManager.chequearColision(aliens[i][j])) {
						aliens[i][j].die();
						muertos++;
						elegirPuntos(aliens[i][j].getType());
					}
				}
			}
		}
	}

	public int getPuntaje() {
		return puntaje;
	}

	private void elegirPuntos(Alien.Tipo alienType) {
		switch(alienType) {
		case ALIEN1:
			puntaje += 30;
			break;
		case ALIEN2:
			puntaje += 20;
			break;
		case ALIEN3:
			puntaje += 10;
			break;
		}

		if(muertos % 55 == 0 && muertos != 0) {
			muertos = 0;
			resetear();
		}
	}

	public boolean aterrizo() {
		return aliens[4][10].getPosY() >= 550;
	}

	public void draw(Graphics graphics, SpriteManager sm) {
		for(int i = 0; i < aliens.length; i++) {
			for(int j = 0; j < aliens[i].length; j++) {
				if(!aliens[i][j].isDead()) {
					aliens[i][j].updateDeathAnimation();
					aliens[i][j].draw(graphics, sm);
				}
			}
		}
	}
}
