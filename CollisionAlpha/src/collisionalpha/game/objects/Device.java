package collisionalpha.game.objects;

import java.util.ArrayList;

import collisionalpha.game.GameMain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Device extends GameObject {

	public Device(int objectID, float posX, float posY, float mass, float friction, 
			float hitWidth, float hitHeight, float hitX, float hitY, int[] colliders, 
			boolean isSolid, float touchRadius, boolean isTouchable, float drawWidth, 
			float drawHeight, Texture sprites, int srcWidth, int srcHeight)
	 {
		super(objectID, posX, posY, mass, friction, hitWidth, hitHeight, hitX, hitY, colliders,
				isSolid, touchRadius, isTouchable, drawWidth, drawHeight, sprites, srcWidth, srcHeight, 10);
		
		
	}
	
	@Override
	public void update(float dt, ArrayList<GameObject> objects) {
		
		if(this.getHp() == 0){
			return;
		}
		
		super.update(dt, objects);
		if(this.get_positionX() <= this.getDrawWidth()/ 2)
		{
			this.set_position(this.get_hitWidth()/2 + 2, this.get_positionY());
			this.add_velocity(200, 0);
		}
		if(this.get_positionY() <= this.getDrawHeight()/2){
			this.set_position(this.get_positionX(), this.getDrawHeight()/2 + 2);
			this.add_velocity(0, 200 );
			//System.out.println("under the line");
		}
		if(this.get_positionX() >= GameMain.CONFIG_WIDTH - this.getDrawWidth()/2 ){
			this.set_position(GameMain.CONFIG_WIDTH - this.getDrawWidth()/2 - 1, this.get_positionY());
			this.add_velocity(-200, 0);
		}
		
		if(this.get_positionY() >= GameMain.CONFIG_HEIGHT - this.getDrawHeight()/2)
		{
			this.set_position(this.get_positionX(), GameMain.CONFIG_HEIGHT - this.getDrawHeight()/2 - 1);
			this.add_velocity(0, -200);
		}
	}

}
