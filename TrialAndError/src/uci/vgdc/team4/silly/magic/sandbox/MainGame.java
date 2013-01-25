package uci.vgdc.team4.silly.magic.sandbox;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {

	private Texture background;
	private Texture figure;
	
	private SpriteBatch batch;
	
	private Hero hero;
	
	@Override
	public void create() {
		background = new Texture(Gdx.files.internal("data/LightBlue.png"));
		figure     = new Texture(Gdx.files.internal("data/Arrows.png"));
		batch      = new SpriteBatch();
		
		hero = new Hero(figure);
		Gdx.input.setInputProcessor(new Controller(hero));
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		background.dispose();
		figure.dispose();
		batch.dispose();
		// TODO Auto-generated method stub
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void render() {
		update();
		
		// Clears the screen.
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// Draws the background.
		batch.begin();
		batch.draw(background, 0, 0);
		hero.draw(batch);
		batch.end();
		// TODO Auto-generated method stub
	}
	
	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}
	
	public void update() {
		hero.act(Gdx.graphics.getDeltaTime());
	}
}
