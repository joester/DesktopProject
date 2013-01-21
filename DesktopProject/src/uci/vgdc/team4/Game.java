package uci.vgdc.team4;
import uci.vgdc.team4.timer.GameTimer;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener{

	/**
	 * @param args
	 */
	
	Texture tex;
	Texture tex2;
	Sound effect;
	
	GameTimer timer;

	ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
	ArrayList<XP> XP = new ArrayList<XP>();
	
	@Override
	public void create() {		
		// TODO Auto-generated method stub
		this.timer = new GameTimer(120);
		timer.start();
		
		tex = new Texture(Gdx.files.internal("data/NicCageFace.jpg"));
		tex2 = new Texture(Gdx.files.internal("data/dog.jpg"));
		effect = Gdx.audio.newSound(Gdx.files.internal("data/sound.wav"));
		
		Gdx.app.log("create()", "I CAN DRAW DOG");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		tex.dispose();
		tex2.dispose();
		effect.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		/* Get DT */
		float dt = Gdx.graphics.getDeltaTime();
		
		/* Update */
		timer.update(dt);

		/* Sort */
		Collections.sort(Enemies, new EntityComparator());
		Collections.sort(XP, new EntityComparator());
		
		/* Draw */
		SpriteBatch sprites = new SpriteBatch();
		sprites.begin();
		sprites.draw(tex, 0, 0);
		sprites.draw(tex2, 0, 200);
		sprites.end();
		if(Gdx.input.justTouched()){
			effect.play(.7f);
		}
		
		System.out.println(timer.time());
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
