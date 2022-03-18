package logica;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class SpriteManager {

	private HashMap<String, BufferedImage> sprites = new HashMap<>();
	
	public SpriteManager() {
	}

	public void readSprites() {
		File folder = new File("src/sprites/");
		for(File file : folder.listFiles()) {
			try {
				sprites.put(file.getName(), ImageIO.read(file));
			} catch (IOException e) {
			}
		}
	}

	public BufferedImage getSprite(String name) {
		return sprites.get(name+".png");
	}

	public BufferedImage getSprite(String name, int x, int y, int w, int h) {
		return sprites.get(name+".png").getSubimage(x, y, w, h);
	}
}