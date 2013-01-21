package uci.vgdc.team4;

import java.awt.Point;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity{
	
	// Caches the position of the Box.
	public final Entity box;

	public Enemy(int hp, float speed, Point position, Vector2 velocity,
			Sprite sheet, int sWidth, int sHeight, Entity box) {
		super(hp, speed, position, velocity, sheet, sWidth, sHeight);
		this.box = box;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float dt) {
		double x = box.position.getX() - position.getX();
		double y = box.position.getY() - position.getY();
		double r = Math.sqrt(x*x+y*y);
		if (r == 0)
			return;
		velocity = new Vector2((float)(speed*x/r), (float)(speed*y/r));
		position.setLocation(position.x + velocity.x*dt, position.y + velocity.y*dt);
	}

	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		
	}

}
