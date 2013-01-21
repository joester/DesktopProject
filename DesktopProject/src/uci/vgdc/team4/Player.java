package uci.vgdc.team4;

import java.awt.Point;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{
		
	public Player(int hp, float speed, Point position, Vector2 velocity,
			Sprite sheet, int sWidth, int sHeight) {
		super(hp, speed, position, velocity, sheet, sWidth, sHeight);
		// TODO Auto-generated constructor stub
		sheet = new Sprite(new Texture(Gdx.files.internal("data/bama.jpg")));
	}

	@Override
	public void update(float dt) {
		// TODO Auto-generated method stub
		if(Gdx.input.isTouched()){
			sheet.setX((Gdx.input.getX() - sheet.getX()) / 10);
			sheet.setY((512 - (Gdx.input.getY() - sheet.getY())) / 10);
			System.out.println(sheet.getX() + " " + sheet.getY());
		}
	}


	@Override
	public void render(SpriteBatch batch) {
		// TODO Auto-generated method stub
		sheet.draw(batch);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}


}
