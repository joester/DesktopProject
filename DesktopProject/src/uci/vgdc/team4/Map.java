package uci.vgdc.team4;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Map {
	
	private Texture background;
	private Box b;
	private Player p;
	private int xBounds, yBounds;
	private Rectangle[] bounds = new Rectangle[4];
	
	public Map(Texture background, Game g, int xBounds, int yBounds){
		this.background = background;
		p = g.p;
		b = g.b;
		bounds[0] = new Rectangle(xBounds, 0, xBounds, 1);
		bounds[1] = new Rectangle(0, yBounds, 1, yBounds);
		bounds[2] = new Rectangle(xBounds, yBounds, xBounds, 1);
		bounds[3] = new Rectangle(xBounds, yBounds, 1, yBounds);
		
	}
	
	public void update(float dt){
		onBoxCollide();
		onPlayerCollide();
		spawnMonsters();
	}
	

	
	
	private void onBoxCollide(){
		if(b.position.x == 0 || b.position.x - b.getWidth() == Gdx.graphics.getWidth()){
			b.velocity.x = -b.velocity.x;
		}
		if(b.position.y == 0 || b.position.y - b.getHeight() == Gdx.graphics.getHeight()){
			b.velocity.y = -b.velocity.y;
		}
	}
	
	private void onPlayerCollide(){
		if(p.position.x == 0 || p.position.x - p.getWidth() == Gdx.graphics.getWidth()){
			p.velocity.y = 0;
		}
		if(p.position.y == 0 || p.position.y - p.getHeight() == Gdx.graphics.getWidth()){
			p.velocity.x = 0;
		}
	}
	
	private void spawnMonsters(){
		Random r = new Random();
		
	}
	
	public void render(SpriteBatch batch){
		batch.draw(background, 0, 0);
	}
	
}
