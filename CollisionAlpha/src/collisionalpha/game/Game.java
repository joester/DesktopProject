package collisionalpha.game;


import collisionalpha.game.controls.Controller;
import collisionalpha.game.objects.GameObject;
import collisionalpha.game.objects.Player;
import collisionalpha.game.room.Room;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game implements ApplicationListener
{
	float i = 0, j = 16;
	//TODO Testing
	Texture testure;
	Texture testure2;
	Texture testure3;
	Player testobj;
	Room testroom;
	int[] testcolliders = {1,2};
	
	/* Controls */
	private Controller controller = new Controller();
	
	/* ApplicationListener */
	@Override
	public void create()
	{
		testure = new Texture(Gdx.files.internal("data/grim.png"));
		testure2 = new Texture(Gdx.files.internal("data/Sprite-example.png"));
		testure3 = new Texture(Gdx.files.internal("data/greenball.png"));
		testobj = new Player(0, 90, 90, 1, 300, 32, 32, testcolliders, true, 96, 96, testure, 64, 64);
		
		GameObject box = new GameObject(1,400,400,1,300,58,58,testcolliders,true,64,64,testure3,64,64);
		GameObject blocker = new GameObject(10,200,200,1,300,64,64,testcolliders,true,64,64,testure2,64,64);
		
		testroom = new Room();
		testroom.add_object(box);
		testroom.add_object(blocker);
		testroom.add_object(testobj);
		
		this.controller.add_controllable(testobj);
		this.controller.add_controllable(testroom);
		
		Gdx.input.setInputProcessor(this.controller);
	}//END create

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub
		testure.dispose();
		testure2.dispose();
		testure3.dispose();
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
		testroom.update(dt);
		
		/* Render */
		//Clear
		Gdx.graphics.getGL20().glClearColor(1, 1, 1, 1);
		Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		//Draw
		SpriteBatch spritebatch = new SpriteBatch();
		spritebatch.begin();
		testroom.render(spritebatch);
		spritebatch.end();
		spritebatch.dispose();
	}//END render

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
}//END class Game

//EOF