package collisionalpha.game.objects;

import java.util.ArrayList;

import collisionalpha.game.GameMain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Device extends GameObject {

	public Device(int objectID, float posX, float posY, float mass,
			float friction, float hitWidth, float hitHeight, int[] colliders,
			boolean isSolid, float drawWidth, float drawHeight,
			Texture sprites, int srcWidth, int srcHeight) {
		super(objectID, posX, posY, mass, friction, hitWidth, hitHeight, colliders,
				isSolid, drawWidth, drawHeight, sprites, srcWidth, srcHeight);
		
		
	}
	
	@Override
	public void update(float dt, ArrayList<GameObject> objects) {
		
		super.update(dt, objects);
		if(this.get_positionX() <= 20)
		{
			this.set_position(21, this.get_positionY());
			this.add_velocity(500, 0);
		}
		if(this.get_positionY() <= 20){
			this.set_position(this.get_positionX(), 21);
			this.add_velocity(0, 500 );
			System.out.println("under the line");
		}
		if(this.get_positionX() >= GameMain.CONFIG_WIDTH + 20){
			this.set_position(this.get_positionX() - this.get_hitWidth() - 1, this.get_positionY());
			this.add_velocity(-500, 0);
		}
		
		if(this.get_positionY() >= GameMain.CONFIG_HEIGHT - 20)
		{
			this.set_position(this.get_positionX(), GameMain.CONFIG_HEIGHT - this.get_hitHeight() -10);
			this.add_velocity(0, -500);
		}
	}

}
