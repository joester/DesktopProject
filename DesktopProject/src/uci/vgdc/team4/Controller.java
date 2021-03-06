package uci.vgdc.team4;

import com.badlogic.gdx.InputProcessor;
import java.util.ArrayList;


public class Controller implements InputProcessor{

	
	/*
	 * height: Input taken from top-left corner; we count from bottom left.  Subtract this.
	 */
	private int height;
	protected ArrayList<Controllable> controlled;
	
	public Controller(int height) {
		controlled = new ArrayList<Controllable>();
		this.height = height;
	}
	
	public void addControllable(Controllable c) {
		controlled.add(c);
	}
	
	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int arg2, int arg3) {
		for (Controllable c : controlled)
			c.goToPoint(x, height - y);
		return true;
	}

	@Override
	public boolean touchDragged(int x, int y, int arg2) {
		for (Controllable c : controlled)
			c.goToPoint(x, height - y);
		return true;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
