package uci.vgdc.team4;


import java.util.ArrayList;
import java.util.Collections;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Game implements ApplicationListener{

	
	Texture tex;
	Texture tex2;
	Sound effect;
	static Player p;
	Box box;
	
	GameTimer timer;
	SpriteBatch spriteBatch;
	ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
	ArrayList<XP> XP = new ArrayList<XP>();
	
	@Override
	public void create() {		
		// TODO Auto-generated method stub
		this.timer = new GameTimer(120);
		timer.start();
		spriteBatch = new SpriteBatch();
		tex = new Texture(Gdx.files.internal("data/bg.jpg"));
		effect = Gdx.audio.newSound(Gdx.files.internal("data/sound.wav"));
		box = new Box(0,0,Vector2.Zero,Vector2.Zero,null,0,0);
		p = new Player(1, // Health
				100, // Speed
				new Vector2(0,0), new Vector2(0,0), 
				new Sprite(new Texture(Gdx.files.internal("data/bama.jpg"))), 
				50, // Sprite width
				50);// Sprite height
		Controller controller = new Controller(Gdx.graphics.getHeight());
		controller.addControllable(p);
		Gdx.input.setInputProcessor(controller);
		
		Gdx.app.log("create()", "I CAN DRAW DOG");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		tex.dispose();
		effect.dispose();
		box.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	
	public static Player getPlayer()
	{
		return p;
	}

	@Override
	public void render() {
		/* Get DT */
		float dt = Gdx.graphics.getDeltaTime();
		
		/* Update */
		timer.update(dt);
		box.update(dt);
		/* Sort */
		Collections.sort(Enemies, new EntityComparator());
		Collections.sort(XP, new EntityComparator());
		
		/* Draw */
		
		//Comment out anything that has to do with p if you need to run.
		
		// Clears the screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		spriteBatch.begin();
		spriteBatch.draw(tex, 0, 0);
		box.render(spriteBatch);
		p.render(spriteBatch);
		spriteBatch.end();
		
		p.update(dt);
		
		
		if(Gdx.input.justTouched()){
			effect.play(.7f);
		}
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
