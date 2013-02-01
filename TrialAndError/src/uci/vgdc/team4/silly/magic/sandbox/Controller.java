package uci.vgdc.team4.silly.magic.sandbox;

import com.badlogic.gdx.InputProcessor;

public class Controller implements InputProcessor{

	private Hero hero;

	public Controller(Hero hero) {
		this.hero = hero;
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

	// Positions are from top left of screen.
	
	/*
	 * @param arg0: x position at touch down.
	 * @param arg1: y position at touch down.
	 * @param arg2, arg3: 0
	 */
	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		hero.setGoing(true);
		hero.setDest(arg0, arg1);
		return true;
	}

	/*
	 * @param arg0: x position at touch drag.
	 * @param arg1: y position at touch drag.
	 * @param arg2: 0
	 */
	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		hero.setDest(arg0, arg1);
		return false;
	}

	/*
	 * @param arg0: x position at touch up.
	 * @param arg1: y position at touch up.
	 * @param arg2, arg3: 0
	 */
	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		hero.setGoing(false);
		return false;
	}


}
