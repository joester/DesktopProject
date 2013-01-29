package uci.vgdc.team4;

import com.badlogic.gdx.math.Vector2;

public interface Controllable {

	public void goToPoint(int x, int y);
	public void setVelocity(Vector2 v);
	
}
