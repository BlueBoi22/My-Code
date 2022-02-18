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
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.graphics.OrthographicCamera;
import java.awt.*;


public class Gone4good extends ApplicationAdapter {
	SpriteBatch batch;
	OrthographicCamera camera;
	Texture items;
	Texture background;
	TextureRegion billHud;
	TextureRegion billHead;
	TextureRegion billStanding;
	TextureRegion baseTile;
	TextureRegion botleftcorner;
	Animation billWalking;
	Animation billShootingStart;
	Animation billShootWalk;
	Animation billShootContinue;
	int x = 0;
	int y = 0;
	@Override
	public void create () {
		batch = new SpriteBatch();
		items = new Texture("Gone 4 Good.png");
		background = new Texture("Background.png");
		billHud = new TextureRegion(items, 0, 0, 184,184);
		billHead = new TextureRegion(items, 184, 0, 184, 184);
		billStanding = new TextureRegion(items, 550, 0, 184, 184);
		baseTile = new TextureRegion(background, 0, 0, 460, 460);
		botleftcorner = new TextureRegion(background, 460, 460, 460, 460);
		billWalking = new Animation(0.2f, new TextureRegion(items, 550, 0, 184, 184), new TextureRegion(items, 736, 0, 184, 184));
		billShootingStart = new Animation(.02f, new TextureRegion(items, 0, 184, 184, 184), new TextureRegion(items, 184, 184, 184, 184), new TextureRegion(items, 368, 184, 184, 184), new TextureRegion(items, 552, 184, 184, 184));
		billShootContinue = new Animation(.02f, new TextureRegion(items, 368, 184, 184, 184), new TextureRegion(items, 552, 184, 184, 184));
		billShootWalk = new Animation(0.2f, new TextureRegion(items, 736, 184, 184, 184), new TextureRegion(items, 0, 368, 184, 184), new TextureRegion(items, 184, 368, 184, 184), new TextureRegion(items, 184, 552, 184, 184));
	}

	
	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		Gdx.graphics.getWidth();
		Gdx.graphics.getHeight();
		batch.draw(botleftcorner, x, y);
		batch.draw(baseTile, x + 200, y + 200);
		if (Gdx.input.isKeyPressed(Input.Keys.W)){
			y -= 10;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.S)){
			y += 10;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.A)){
			x += 10;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.D)){
			x -= 10;
		}
		batch.draw(billStanding, 875, 450);
		batch.draw(billHud, 0, 0);
		int mouseposx = Gdx.input.getX();
		int mouseposy = Gdx.input.getY();
		float angle = MathUtils.atan2(825 - mouseposy, mouseposx - 533);
		float degrees = (float) (180.0 * angle / Math.PI);
		batch.draw(billHead, 895, 602, 23,23, 46, 46, 4, 4, degrees);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		items.dispose();
		background.dispose();
	}
}
