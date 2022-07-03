package com.port.utils.loader;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.badlogic.gdx.files.FileHandle;
import com.port.world.WorldData;

/*
 * incarca matricele pentru pathfind in WorldData
 */

public abstract class Loader {

	public static int[][] loadMatrix(File fin) {
		int[][] mat = new int[WorldData.maxLengthWorld][WorldData.maxWidthWorld];
		try {
			Scanner scan = new Scanner(fin);

			for (int i = 0; i < WorldData.maxLengthWorld; i++) {

				for (int j = 0; j < WorldData.maxWidthWorld; j++) {
					//System.out.format("%d ", mat[i][j]=scan.nextInt());
					mat[i][j] = scan.nextInt();
				}

			}

			scan.close();

		} catch (InputMismatchException e) {
			System.out.print(e.getMessage()); // try to find out specific reason.
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return null;
		}
		return mat;
	}

}
