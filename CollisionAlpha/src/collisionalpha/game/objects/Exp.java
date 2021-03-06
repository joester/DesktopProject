package collisionalpha.game.objects;

import java.util.ArrayList;
import java.util.Random;

import collisionalpha.game.GameMain;
import collisionalpha.game.objects.actions.Goto;
import collisionalpha.game.room.Room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Exp extends GameObject{

	private ArrayList<Experience> exps = new ArrayList<Experience>();
	Device device;
	static Random rand = new Random();
	Room room;
	public Exp(Device device, int objectID, float posX, float posY, float mass,
			float friction, float hitWidth, float hitHeight, float hitX,
			float hitY, int[] colliders, boolean isSolid, float touchRadius,
			boolean isTouchable, float drawWidth, float drawHeight,
			Texture sprites, int srcWidth, int srcHeight, int hp) {
		super(objectID, posX, posY, mass, friction, hitWidth, hitHeight, hitX, hitY,
				colliders, isSolid, touchRadius, isTouchable, drawWidth, drawHeight,
				sprites, srcWidth, srcHeight, hp);
		
	
		
	}
	public Exp(Device d, Room room,  Texture t){
		super(t);
		this.speed = 100;
		this.device = d;
		this.room = room;
		
	}
	public Rectangle quadrant()
	{
		int width = GameMain.CONFIG_WIDTH; int height = GameMain.CONFIG_HEIGHT;
		int x = 3;
		int quadWidth = (int) (width - 3 * device.drawWidth);
		int quadHeight = (int) (height - 3 * device.drawHeight);
		Rectangle r1 = new Rectangle(width - quadWidth, height - quadHeight, quadWidth, quadHeight);
		Rectangle r2 = new Rectangle(width - quadWidth, quadHeight, quadWidth, quadHeight);
		Rectangle r3 = new Rectangle(0, 0, quadWidth, quadHeight);
		Rectangle r4 = new Rectangle(0, height - quadHeight, quadWidth, quadHeight);
		Rectangle deviceRect = new Rectangle(device.get_positionX(), device.get_positionY(), device.getDrawWidth(), device.getDrawHeight());
		if(r1.overlaps(deviceRect))
			return r1;
		else if (r2.overlaps(deviceRect)) return r2;
		else if (r3.overlaps(deviceRect)) return r3;
		else if (r4.overlaps(deviceRect)) return r4;
		else return null;
		
	}
	
	public Vector2 getNextSpawn(Rectangle r)
	{
			Rectangle rect = new Rectangle(300, 300,//rand.nextInt(GameMain.CONFIG_WIDTH), rand.nextInt(GameMain.CONFIG_HEIGHT),
								65,58);
			return new Vector2(rect.x, rect.y);
			
		
	}
	
	public Experience makeNewExp(Vector2 v)
	{
		Experience e = new Experience(999, device.get_positionX(), device.get_positionY(), 
				1f, 1f, 65f, 58f, 0f, 0f,
					new int[0], true, 40f, true, 65f, 58f,
					new Texture(Gdx.files.internal("data/xp.png")), 65, 58, 0);
		e.speed = 100;
		return e;
	}
	
	float time = 0;
	public void update(float dt) {
		
		//Rectangle quad = quadrant();
		
		Rectangle rect = new Rectangle((float)(this.get_positionX()- 1.5 * this.getDrawWidth()),
				(float)(this.get_positionY() - 1.5 * this.getDrawHeight()),
										3 * this.getDrawWidth(), 3 * this.getDrawHeight());
		time += dt;							
		if(time > 2)
		{
			time = 0;
			Experience e = makeNewExp(new Vector2(device.get_position()));
			e.setGoTo(getNextSpawn(rect));
			exps.add(e);
			room.add_object(e);
		}
		
		for(Experience ee : exps)
		{

			ee.update(dt, new ArrayList<GameObject>());
		}
	}
	
	private static class Experience extends GameObject{

		public Experience(int objectID, float posX, float posY, float mass,
				float friction, float hitWidth, float hitHeight, float hitX,
				float hitY, int[] colliders, boolean isSolid,
				float touchRadius, boolean isTouchable, float drawWidth,
				float drawHeight, Texture sprites, int srcWidth, int srcHeight,
				int hp) {
			super(objectID, posX, posY, mass, friction, hitWidth, hitHeight, hitX, hitY,
					colliders, isSolid, touchRadius, isTouchable, drawWidth, drawHeight,
					sprites, srcWidth, srcHeight, hp);
			// TODO Auto-generated constructor stub
		}
		
	
		public void setGoTo(Vector2 v)
		{
			//this.action_queue.add_action(new Goto(v.x, v.y));
		}
	}

}
