package com.port;

import greenfoot.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Math;

public class PereteInvizibil extends Perete {

	private String marime;
	private String pozitie;

	GreenfootImage pereteImg = super.micImg;

	int floor;

	public PereteInvizibil(String pozitie, int floor, String marime) {

		this.floor = floor;
		this.marime = marime;

		switch (marime) {
		case "mic90": {
			pereteImg = super.mic90Img;
			break;
		}
		case "mic": {
			pereteImg = super.micImg;
			break;
		}
		}

		setImage(pereteImg);
		this.pozitie = pozitie;

	}

	private void chestie() {
		float procentX = 100;
		float procentY = 95f;
		switch (pozitie) {
		case ("W"): {
			if (marime.equals("mic90")) {
				float a = getImage().getWidth() / 2;

				for (int i = 0; i <= a; i += 10) {

					Actor b = getOneObjectAtOffset(i, 0, Movers.class);
					if (b != null) {
						float dif = b.getY() - getY();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() + k);
					}
				}

				for (int j = 10; j <= a; j += 10) {
					Actor b = getOneObjectAtOffset(-j, 0, Movers.class);
					if (b != null) {
						float dif = b.getY() - getY();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() + k);
					}

				}
			} else {
				float a = getImage().getWidth() / 2;

				for (int i = 0; i <= a; i += 20) {

					Actor b = getOneObjectAtOffset(i, 0, Movers.class);

					if (b != null) {
						float dif = b.getY() - getY();

						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() + k);
					}
				}

				for (int j = 0; j <= a; j += 20) {
					Actor b = getOneObjectAtOffset(-j, 0, Movers.class);

					if (b != null) {
						float dif = b.getY() - getY();

						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() + k);
					}
				}
			}

			break;
		}

		case ("S"): {
			// dif=b.getY()-getY()-i
			if (marime.equals("mic90")) {
				float a = getImage().getWidth() / 2;

				for (int i = 0; i <= a; i += 10) {

					Actor b = getOneObjectAtOffset(i, 0, Movers.class);
					if (b != null) {
						float dif = getY() - b.getY();

						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() - k);
					}
				}

				for (int j = 10; j <= a; j += 10) {
					Actor b = getOneObjectAtOffset(-j, 0, Movers.class);
					if (b != null) {
						float dif = getY() - b.getY();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() - k);
					}

				}
			} else {
				float a = getImage().getWidth() / 2;
				for (int i = 0; i <= a; i += 20) {

					Actor b = getOneObjectAtOffset(i, 0, Movers.class);
					if (b != null) {
						float dif = getY() - b.getY();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() - k);
					}
				}

				for (int j = 0; j <= a; j += 20) {
					Actor b = getOneObjectAtOffset(-j, 0, Movers.class);
					if (b != null) {
						float dif = getY() - b.getY();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getHeight() / 2;
						}
						k -= k * procentY / 100;
						b.setLocation(b.getX(), b.getY() - k);
					}

				}
			}
			break;
		}

		case ("D"): {
			if (marime.equals("mic90")) {
				float a = getImage().getHeight() / 2;

				for (int i = 0; i <= a; i += 10) {

					Actor b = getOneObjectAtOffset(0, i, Movers.class);
					if (b != null) {
						float dif = getX() - b.getX();

						float k = getImage().getWidth() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() - k, b.getY());
					}
				}

				for (int j = 0; j <= a; j += 10) {
					Actor b = getOneObjectAtOffset(0, -j, Movers.class);
					if (b != null) {
						float dif = getX() - b.getX();
						float k = getImage().getWidth() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() - k, b.getY());
					}

				}
			} else {
				float a = getImage().getHeight() / 2;
				for (int i = 0; i <= a; i += 20) {

					Actor b = getOneObjectAtOffset(0, i, Movers.class);
					if (b != null) {
						float dif = getX() - b.getX();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() - k, b.getY());
					}
				}

				for (int j = 0; j <= a; j += 20) {
					Actor b = getOneObjectAtOffset(0, -j, Movers.class);
					if (b != null) {
						float dif = getX() - b.getX();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() - k, b.getY());
					}

				}
			}
			break;
		}

		case ("A"): {
			if (marime.equals("mic90")) {
				float a = getImage().getHeight() / 2;

				for (int i = 0; i <= a; i += 10) {

					Actor b = getOneObjectAtOffset(0, i, Movers.class);
					if (b != null) {
						float dif = b.getX() - getX();

						float k = getImage().getWidth() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() + k, b.getY());
					}
				}

				for (int j = 0; j <= a; j += 10) {
					Actor b = getOneObjectAtOffset(0, -j, Movers.class);
					if (b != null) {
						float dif = b.getX() - getX();
						float k = getImage().getWidth() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() + k, b.getY());
					}

				}
			} else {
				float a = getImage().getHeight() / 2;
				for (int i = 0; i <= a; i += 20) {

					Actor b = getOneObjectAtOffset(0, i, Movers.class);
					if (b != null) {
						float dif = b.getX() - getX();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() + k, b.getY());
					}
				}

				for (int j = 0; j <= a; j += 20) {
					Actor b = getOneObjectAtOffset(0, -j, Movers.class);
					if (b != null) {
						float dif = b.getX() - getX();
						float k = getImage().getHeight() / 2 - dif;
						if (k <= 0) {
							k = k * (-1) + getImage().getWidth() / 2;
						}
						k -= k * procentX / 100;
						b.setLocation(b.getX() + k, b.getY());
					}
				}
			}
			break;
		}
		}
	}

	void chestie2() {
		Player player = (Player) (((PlayWorld) getWorld()).getPlayer());
		if (intersects(player)) {
			if (player != null) {
				switch (pozitie) {
				case "W": {
					player.setLocation(player.getX(), player.getY() + player.getSpeed());
					break;
				}
				case "A": {
					player.setLocation(player.getX() + player.getSpeed(), player.getY());
					break;
				}
				case "S": {
					player.setLocation(player.getX(), player.getY() - player.getSpeed());
					break;
				}
				case "D": {
					player.setLocation(player.getX() - player.getSpeed(), player.getY());
					break;
				}

				}
			}
		}
	}

	public void act() {

		if (isInScreenRange() && !WorldData.PAUZA) {
			// chestie();
			chestie2();
		}

	}

	public String getPozitie() {
		return pozitie;
	}

}
