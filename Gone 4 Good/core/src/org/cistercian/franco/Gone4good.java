package org.cistercian.franco;

import javax.xml.transform.TransformerFactoryConfigurationError;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

public class Gone4good extends ApplicationAdapter {
	SpriteBatch batch;
	Texture items;
	TextureRegion billHud;
	TextureRegion billHead;
	TextureRegion billStanding;
	Animation billWalking;
	Animation billShooting;
	Animation billShootWalk;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		items = new Texture("Gone 4 Good.png");
		billHud = new TextureRegion(items, 0, 0, 46,46);
		billHead = new TextureRegion(items, 46, 0, 46, 46);
		billStanding = new TextureRegion(items, 138, 0, 46, 46);
		billWalking = new Animation(0.2f, new TextureRegion(items, 138, 0, 46, 46), new TextureRegion(items, 184, 0, 46, 46));
		billShooting = new Animation(.02f, new TextureRegion(items, 0, 46, 46, 46), new TextureRegion(items, 46, 46, 46, 46), new TextureRegion(items, 92, 46, 46, 46), new TextureRegion(items, 138, 46, 46, 46));
		billShootWalk = new Animation(0.2f, new TextureRegion(items, 184, 46, 46, 46), new TextureRegion(items, 0, 92, 46, 46), new TextureRegion(items, 46, 92, 46, 46), new TextureRegion(items, 46, 138, 46, 46));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
