package com.game.straferliberator.desktop;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.game.straferliberator.StraferLiberator;

public class DesktopLauncher {
	public static Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

	public static void main(String[] arg) {
	
		config.setTitle( "Strafer Liberator");
		config.setWindowIcon(FileType.Internal, "icons/icon_128.png","icons/icon_64.png","icons/icon_32.png","icons/icon_16.png");
		//config.setDecorated(false);
		config.setWindowedMode(com.port.world.WorldData.WIDTH, com.port.world.WorldData.HEIGHT);
		config.setResizable(false);
		

		config.setForegroundFPS(90);
		config.useVsync(true);


		new Lwjgl3Application(new StraferLiberator(), config);

	}
}
