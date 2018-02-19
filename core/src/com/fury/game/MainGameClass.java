package com.fury.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MainGameClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture backGround;
	Map map;
	Tank player;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		backGround = new Texture("background1.png");
		map = new Map();
		player = new Tank(map, new Vector2(100,500));
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
		player.render(batch);
		batch.end();
	}

	public void update(float dt) {
		player.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backGround.dispose();
	}
}
