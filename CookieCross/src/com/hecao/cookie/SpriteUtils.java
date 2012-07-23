package com.hecao.cookie;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteUtils {
	
	public static List getSprite(Texture texture, int[] coordinates) {
		

		ArrayList result = new ArrayList();
		for (int i = 0 ; i < coordinates.length ; ) {
			System.out.print(i + " _" + coordinates.length + "|");
			int x = coordinates[i++];
			int y = coordinates[i++];
			int height = coordinates[i++];
			int width = coordinates[i++];
			TextureRegion tg = new TextureRegion(texture, x, y, width, height);
			result.add(tg);
		}
		
		return result;
	}

}
