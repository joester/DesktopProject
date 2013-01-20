package uci.vgdc.team4;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DeskMain {
	public static void main(String[] args) {
		new LwjglApplication(new DaGame(), "dog", 512, 512, true);
	}
}
