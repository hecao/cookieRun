package com.hecao.cookie;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class CookieCross implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	private BitmapFont bf;
	private Animation tree1Animation;
	private Animation tree2Animation;
	private float runningTime = 0;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
//		camera = new OrthographicCamera(2, h/w * 2);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.5f, 0.5f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		bf = new BitmapFont();
		tree1Animation = TreeLoader.loadTreeAnimation(Trees.TREE1);
		tree1Animation.setPlayMode(Animation.LOOP);
		tree2Animation = TreeLoader.loadTreeAnimation(Trees.TREE2);
		tree2Animation.setPlayMode(Animation.LOOP);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
//		batch.setProjectionMatrix(camera.combined);
		
		float deltaTime = Gdx.graphics.getDeltaTime();
		runningTime += deltaTime;
		TextureRegion tg = tree1Animation.getKeyFrame(runningTime);
		TextureRegion tree2 = tree2Animation.getKeyFrame(runningTime);
		batch.begin();
//		sprite.draw(batch);
		bf.draw(batch, "Testin¡ª¡ªMkey libgdx(2)", 100, 100);
		batch.draw(tg, 0, 0);
		batch.draw(tree2, 65, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
