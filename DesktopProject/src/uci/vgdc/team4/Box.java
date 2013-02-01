package uci.vgdc.team4;

import java.awt.Point;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Box extends Entity{

	public Box(int hp, float speed, Vector2 position, Vector2 velocity,
			Sprite sheet, int sWidth, int sHeight) {
		super(hp, speed, position, velocity, sheet, sHeight, sHeight);
		box = new Texture(Gdx.files.internal("data/box.png"));
		this.position = new Vector2(300,300);
	}
	
	Texture box; 
	
	
	@Override
	public void update(float dt) {
		
		Rectangle rect = new Rectangle(this.position.x, this.position.y, box.getWidth(), box.getHeight());
		if(rect.overlaps(Game.getPlayer().getRect()))
		{
			this.velocity = Game.getPlayer().getVeclocity().cpy();
			System.out.println(Game.getPlayer().getRect());
		}

			position.add(this.velocity);
			velocity = velocity.mul(.15f);

		
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(box, position.x, position.y);		
		
	}

	@Override
	public void create() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}

}
