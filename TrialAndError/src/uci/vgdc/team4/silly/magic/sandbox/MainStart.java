package uci.vgdc.team4.silly.magic.sandbox;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class MainStart {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.height    = 512;
		config.width     = 512;
		config.useGL20   = true;
		new LwjglApplication(new MainGame(), config);
	}
}
