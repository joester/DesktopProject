package uci.vgdc.team4;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DeskMain {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.height = 800;
		config.width = 1280;
		config.useGL20 = true;
		new LwjglApplication(new Game(), config);
	}
}
