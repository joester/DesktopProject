package uci.vgdc.team4;

import java.awt.Point;
import java.util.ArrayList;

import collisionalpha.game.draw.Animator;
import collisionalpha.game.objects.GameObject;
import collisionalpha.game.objects.actions.Action;
import collisionalpha.game.objects.actions.Goto;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends GameObject{
	
	// Caches the position of the Box.
	public final Entity box;
	private Animator animator;
	private Action action;

	public Enemy(int hp, Sprite sheet, int sWidth, int sHeight, int[] colliders, Entity box) {
		super(101, 300f, 500f, 20f, 5f, sheet.getWidth(), 
				sheet.getHeight(), colliders, true, sheet.getWidth(),
				sheet.getHeight(), sheet.getTexture(), sWidth, sHeight);
		this.box = box;
		this.animator = new Animator(sheet, sWidth, sHeight);
		this.action = new Goto(box.getX(), box.getY());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float dt, ArrayList<GameObject> list){
		action.act(this);
	}
}
