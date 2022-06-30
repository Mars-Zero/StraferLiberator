package com.game.straferliberator.screen;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import com.game.straferliberator.StraferLiberator;
import com.port.world.WorldData;

import greenfoot.GreenfootSound;

public class LoadingScreen implements Screen {

	private final StraferLiberator game;

	private ShapeRenderer shapeRenderer;

	private float progress;

	public LoadingScreen(final StraferLiberator game) {
		this.game = game;
		shapeRenderer = new ShapeRenderer();

		queueAssets();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	private void update(float delta) {

		progress = MathUtils.lerp(progress, game.assetManager.getProgress(), .1f);

		if (game.assetManager.update()) {
			if (progress >= game.assetManager.getProgress() - .001f) {
				System.out.println("gata");
				 game.setScreen(new GameScreen(game));
			}
		}

		System.out.println("loader");
	}

	@Override
	public void render(float delta) {
		GL20 gl = Gdx.gl;
		gl.glClearColor(0, 0, 0, 0);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		update(delta);

		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.valueOf("#40444b"));
		shapeRenderer.rect(0, WorldData.HEIGHT / 2 - 435 / 2f, WorldData.WIDTH * progress, 435);
		shapeRenderer.end();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		shapeRenderer.dispose();

	}

	private void queueAssets() {
		// game.assetManager.setLoader(TextureRegion.class,new TextureLoader(new
		// InternalFileHandleResolver()));
		game.assetManager.load("images/UI/menu/mainMenu/logo.png", Texture.class);
		game.assetManager.load("images/UI/hud/healthBar.png", Texture.class);
		
		game.assetManager.load("images/UI/menu/test2.gif", Texture.class);
		game.assetManager.load("images/C.jpg", Texture.class);
		game.assetManager.load("images/cioata.png", Texture.class);
		game.assetManager.load("images/logo.png", Texture.class);
		game.assetManager.load("images/UI/menu/mainMenu/blur.gif", Texture.class);
	}

}