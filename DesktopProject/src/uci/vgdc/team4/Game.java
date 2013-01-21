package uci.vgdc.team4;
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
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		SpriteBatch sprites = new SpriteBatch();
		sprites.begin();
		sprites.draw(tex, 0, 0);
		sprites.draw(tex2, 0, 200);
		sprites.end();
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
