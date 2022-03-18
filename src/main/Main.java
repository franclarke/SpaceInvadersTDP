package main;

import java.util.Timer;
import java.util.TimerTask;



public class Main{


	public static void main(String args[]) {

		main.GUI gui = new GUI();
		@SuppressWarnings("unused")
		WindowManager window = new WindowManager(gui);
		Timer timer = new Timer();

		class Repetir extends TimerTask implements Runnable{

			public void run() {
				gui.actionPerformed(null);
			}
		}
		int FPS = 30;
		TimerTask repetir = new Repetir();
		timer.schedule(repetir,0,1000/FPS);
	}
}

