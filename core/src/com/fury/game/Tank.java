package com.fury.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Tank {
    private Texture textureBody;
    private Texture textureTracks;
    private Texture textureTurret;
    private Vector2 position;
    private Map map;
    private float turretAngle;
    private int hp;
    private int maxHp;

    private final Vector2 POSITION_BODY;
    private final Vector2 POSITION_TRACKS;
    private final Vector2 POSITION_TURRET;
    private final Vector2 POSITION_CENTER_TANK;
    private static final float ROTATE_TURRET_V = 90.0f;

    public Tank(Map map, Vector2 position) {
        this.map = map;
        this.position = position;
        this.POSITION_BODY = new Vector2(position);
        this.POSITION_TRACKS = new Vector2(position).add(3, -11);
        this.POSITION_TURRET = new Vector2(position).add(45, 33);
        this.POSITION_CENTER_TANK = new Vector2(position);
        this.textureBody = new Texture("tanks_tankNavy_body1.png");
        this.textureTracks = new Texture("tanks_tankTracks2.png");
        this.textureTurret = new Texture("tanks_turret2.png");
        this.turretAngle = 0.0f;
        this.maxHp = 100;
        this.hp = this.maxHp;

    }

    public void render(SpriteBatch batch) {
        batch.draw(textureTurret,POSITION_TURRET.x, POSITION_TURRET.y, 0, 7, 48, 15, 1, 1, turretAngle, 0,0, 48 ,15 ,false, false);
        batch.draw(textureTracks,POSITION_TRACKS.x, POSITION_TRACKS.y);
        batch.draw(textureBody,POSITION_BODY.x, POSITION_BODY.y);
    }

    public void rotateTurret(int n, float dt) {
        turretAngle += n * ROTATE_TURRET_V * dt;
    }

    public void update(float dt) {
        //Control angle turret
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rotateTurret(1, dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rotateTurret(-1, dt);
        }
    }
}
