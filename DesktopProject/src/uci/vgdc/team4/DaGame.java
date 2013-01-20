package uci.vgdc.team4;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DaGame extends Game{

	TextureRegion tex;
	Sound effect;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
		tex = new TextureRegion(new Texture(Gdx.files.internal("data/NicCageFace.jpg")));
		effect = Gdx.audio.newSound(Gdx.files.internal("data/sound.wav"));
		
		Gdx.app.log("create()", "I CAN DRAW DOG");
		
		setScreen(new TestScreen(this));
	}
	

}
