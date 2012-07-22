package com.hecao.cookie;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteUtils {
	
	public static List getSprite(Texture texture, int singleWidth, int singleHeight, int count) {
		

		ArrayList result = new ArrayList();
		
		int textureW = texture.getWidth();
		int textureH = texture.getHeight();
		
		int x = 0;
		int y = 0;
		for (int i = 0 ; i < count; i ++) {
			TextureRegion tg = new TextureRegion(texture, x, y, singleWidth, singleHeight);
			result.add(tg);
			x += singleWidth;
			if (x >= textureW) {
				x = 0;
				y += singleHeight;
			}
		}
		
		return result;
	}

}
