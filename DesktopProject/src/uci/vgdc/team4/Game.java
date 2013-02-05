package uci.vgdc.team4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import collisionalpha.game.objects.GameObject;

import com.badlogic.gdx.*;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Game implements ApplicationListener{

	Sound effect;
	static Player p;
	Box b;
	GameTimer timer;
	Map m;
	SpriteBatch spriteBatch;
	ArrayList<Enemy> Enemies = new ArrayList<Enemy>();
	ArrayList<XP> XP = new ArrayList<XP>();
	
	@Override
	public void create() {		
		// TODO Auto-generated method stub
		this.timer = new GameTimer(120);
		timer.start();
		effect = Gdx.audio.newSound(Gdx.files.internal("data/sound.wav"));
		p = new Player(1, 100, new Vector2(0,0), new Vector2(0,0),
				new Sprite(new Texture(Gdx.files.internal("data/bama.jpg"))), 50, 50);
		b = new Box(0, 0, new Vector2(400, 400), new Vector2(0, 0), new Sprite(new Texture("data/box.png")), 0, 0);
		m = new Map(new Texture(Gdx.files.internal("data/back.jpg")), this, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Enemy e = new Enemy(1, new Sprite(new Texture(Gdx.files.internal("data/enemy.png"))), 41, 43, null, b);
		Enemies.add(e);
		Controller controller = new Controller(Gdx.graphics.getHeight());
		controller.addControllable(p);
		Gdx.input.setInputProcessor(controller);
		
		Gdx.app.log("create()", "I CAN DRAW DOG");
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		effect.dispose();
		b.dispose();
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
		b.update(dt);
		/* Sort */
		Collections.sort(Enemies, new Comparator<Enemy>(){
			public int compare(Enemy e1, Enemy e2){
				return (e1.getID() > e2.getID() ? 1 : -1);
			}
		});
		Collections.sort(XP, new EntityComparator());
		
		/* Draw */
		
		//Comment out anything that has to do with p if you need to run.
		
		// Clears the screen
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		SpriteBatch sprites = new SpriteBatch();

		sprites.begin();
		m.render(sprites);
		b.render(sprites);	
		p.render(sprites);
		for(Enemy e : Enemies){
			e.render(sprites);
			e.update(Gdx.graphics.getDeltaTime(), new ArrayList<GameObject>());
		}
		sprites.end();
		
		p.update(dt);
		m.update(dt);
		
		
		
		
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
