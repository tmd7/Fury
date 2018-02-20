package com.fury.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MainGameClass extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture backGround;
	private Map map;
	private Tank player;
	private BulletEmitter bulletEmitter;

	public static final float GLOBAL_GRAVITY = 300.0f;

	public BulletEmitter getBulletEmitter() {
		return bulletEmitter;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		backGround = new Texture("background1.png");
		map = new Map();
		player = new Tank(this, new Vector2(100,100));
		bulletEmitter = new BulletEmitter();
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
		bulletEmitter.render(batch);
		batch.end();
	}

	public void update(float dt) {
		player.update(dt);
		bulletEmitter.update(dt);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		backGround.dispose();
	}
}
