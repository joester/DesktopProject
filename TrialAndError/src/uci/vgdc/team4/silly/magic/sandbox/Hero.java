package uci.vgdc.team4.silly.magic.sandbox;

import java.awt.Point;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hero {
	
	private Point pos   = new Point();
	private int   xFace = 0;
	private int   yFace = -1;
	
	private boolean going = false;
	private Point dest = new Point();
	
	public final int imgWidth  = 85;
	public final int imgHeight = 85;
	
	public final int speed = 200;
	
	private Texture image;
	
	public Hero(Texture image) {
		this.image = image;
		pos.x = 256;
		pos.y = 256;
	}
	
	// @draw: Note that Sprite batch prints from the bottom left of screen, while
	//        our positions are counted from the top left.
	public void draw(SpriteBatch batch) {
		int imgX = (1 + xFace)*imgWidth;
		int imgY = (1 - yFace)*imgHeight;
		batch.draw(image, pos.x - imgWidth/2, 512 - pos.y - imgHeight/2, imgX, imgY, imgWidth, imgHeight);
	}
	
	public void setGoing(boolean b) {
		going = b;
	}
	
	public void setDest(int x, int y) {
		dest.x = x;
		dest.y = y;
	}
	
	public void act(float delta) {
		if (!going)
			return;
		
		double x = dest.x - pos.x;
		double y = dest.y - pos.y;
		double r = Math.sqrt(x*x + y*y);
		if (r == 0)
			return;
		x /= r;
		y /= r;
		
		if (x > .3)
			xFace = 1;
		else if (x < -.3)
			xFace = -1;
		else
			xFace = 0;
		
		if (y > .3)
			yFace = -1;
		else if (y < -.3)
			yFace = 1;
		else
			yFace = 0;
		
		pos.x += x*speed*delta;
		pos.y += y*speed*delta;
	}
}
