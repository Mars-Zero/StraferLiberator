package com.port.UI.menu;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.game.straferliberator.StraferLiberator;
import com.port.UI.buton.Buton;
import com.port.system.SaveSystem;
import com.port.utils.graphics.GifImage;
import com.port.utils.graphics.Picture;
import com.port.world.WorldData;

import greenfoot.*;


public class MainMenu extends Menu {

	GifImage background = new GifImage("UI/menu/mainMenu/blur.gif");
	// GifImage background=new
	// GifImage(StraferLiberator.assetManager.get("UI/menu/test2.gif",Texture.class));
	Actor logo = new Actor();
	GifImage playerAnimationGif=new GifImage("UI/menu/mainMenu/playerAnimation.gif");
	Actor playerAnimation=new Actor();
	
	Buton butonContinue = new Buton("continue", this);
	Buton butonNewGame = new Buton("newGame", this);
	
	
	List<Actor> thingsToRemove = new ArrayList<>();

	boolean addedStuff = false;

	public GreenfootSound music;

	public MainMenu() {

		WorldData.PAUZA = true;
		WorldData.saveFileNumber = com.port.system.SaveSystem.getNumberOfSaveFiles() - 1;

		logo.setImage(new GreenfootImage(
				StraferLiberator.assetManager.get("images/UI/menu/mainMenu/logo.png", Texture.class)));
		background.scale(WorldData.WIDTH, WorldData.HEIGHT);
	}

	private void addStuff() {
		getWorld().addObject(butonContinue, WorldData.WIDTH / 2 - 300, WorldData.HEIGHT - 100);
		getWorld().addObject(butonNewGame, WorldData.WIDTH / 2 + 300, WorldData.HEIGHT - 100);

		getWorld().addObject(logo, WorldData.WIDTH / 2, WorldData.HEIGHT / 2);
		getWorld().addObject(playerAnimation, WorldData.WIDTH/2,220);
		thingsToRemove.add(playerAnimation);
		thingsToRemove.add(logo);
	}

	public List<Actor> getThingsToRemove() {
		return thingsToRemove;
	}

	public void act() {
		setImage(background.getCurrentImage());
		playerAnimation.setImage(playerAnimationGif.getCurrentImage());
		setLocation(300, WorldData.HEIGHT-135);
		if (!addedStuff) {
			addStuff();
			addedStuff = true;
			new Thread(new Runnable() {
				public void run() {
					music = new GreenfootSound("music/Rename.mp3");
					music.playLoop();
					music.setVolume(60);
				}
			}).start();
		}
	}

	public GreenfootSound getMusic() {
		return music;
	}

	public void setMusic(GreenfootSound music) {
		this.music = music;
	}
}
