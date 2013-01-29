package uci.vgdc.team4;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity implements Controllable{
		
	Vector2 destPos = new Vector2();
	public Player(int hp, float speed, Vector2 position, Vector2 velocity,
			Sprite sheet, int sWidth, int sHeight) {
		super(hp, speed, position, velocity, sheet, sWidth, sHeight);
		
	}

	@Override
	public void update(float dt) {
		position.add(velocity.cpy().mul(dt));
		if(velocity.x < 0) position.x = MathUtils.clamp(position.x, destPos.x, position.x);
		if(velocity.y < 0) position.y = MathUtils.clamp(position.y, destPos.y, position.y);
		if(velocity.x > 0) position.x = MathUtils.clamp(position.x, 0, destPos.x);
		if(velocity.y > 0) position.y = MathUtils.clamp(position.y, 0, destPos.y);
	}


	@Override
	public void render(SpriteBatch batch) {
		batch.draw(sheet, position.x, position.y);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToPoint(int x, int y) {
		float dx = x - position.x;
		float dy = y - position.y;
		float r = (float)Math.sqrt(dx*dx+dy*dy);
		if (r==0)
			return;
		velocity.x = speed*dx/r;
		velocity.y = speed*dy/r;
		destPos.x = x;
		destPos.y = y;

	}


}
