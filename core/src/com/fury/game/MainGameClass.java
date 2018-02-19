package com.fury.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGameClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backGround;
	Map map;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		backGround = new Texture("background1.png");
		map = new Map();
	}

	@Override
	public void render () {
		float dt = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		update(dt);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(backGround, 0, 0);
		map.render(batch);
		batch.end();
	}

	public void update(float dt) {

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backGround.dispose();
	}
}
