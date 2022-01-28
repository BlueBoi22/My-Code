package org.cistercian.franco;

import javax.xml.transform.TransformerFactoryConfigurationError;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
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
	Animation billShootingStart;
	Animation billShootWalk;
	Animation billShootContinue;
	int x = 875;
	int y = 450;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		items = new Texture("Gone 4 Good.png");
		billHud = new TextureRegion(items, 0, 0, 184,184);
		billHead = new TextureRegion(items, 184, 0, 184, 184);
		billStanding = new TextureRegion(items, 550, 0, 184, 184);
		billWalking = new Animation(0.2f, new TextureRegion(items, 550, 0, 184, 184), new TextureRegion(items, 736, 0, 184, 184));
		billShootingStart = new Animation(.02f, new TextureRegion(items, 0, 184, 184, 184), new TextureRegion(items, 184, 184, 184, 184), new TextureRegion(items, 368, 184, 184, 184), new TextureRegion(items, 552, 184, 184, 184));
		billShootContinue = new Animation(.02f, new TextureRegion(items, 368, 184, 184, 184), new TextureRegion(items, 552, 184, 184, 184));
		billShootWalk = new Animation(0.2f, new TextureRegion(items, 736, 184, 184, 184), new TextureRegion(items, 0, 368, 184, 184), new TextureRegion(items, 184, 368, 184, 184), new TextureRegion(items, 184, 552, 184, 184));
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(billStanding, x, y);
		batch.draw(billHud, 0, 0);
		batch.draw(billHead, x-50, y+83);
		batch.end();
		if (Gdx.input.isKeyPressed(Input.Keys.W)){
		y += 10;
	}
}


	@Override
	public void dispose () {
		batch.dispose();
		items.dispose();
	}
}
