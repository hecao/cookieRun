package com.hecao.cookie;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class TreeLoader {
	
	public static Animation loadTreeAnimation(Tree tree) {
		
		String baseName = tree.name;
		Texture textTrue = new Texture(Gdx.files.internal("data/" + baseName));
		List tgs = SpriteUtils.getSprite(textTrue, tree.width, tree.height, tree.frameCount);
		System.out.println(tgs.size());
		Animation animation = new Animation(tree.duration, tgs);
		
		return animation;
		
	}

}
