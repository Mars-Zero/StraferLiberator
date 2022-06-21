package com.game.straferliberator.display;



import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.game.straferliberator.display.overlay.GameScreen;

public class StraferLiberator extends Game {
	// used by all screens
	public static SpriteBatch batcher;
	
	public void create () {
		batcher = new SpriteBatch();
		setScreen(new GameScreen(this));
	}
	
	public void render() {
		super.render();
	}
}