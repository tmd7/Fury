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
    private MainGameClass game;
    private float turretAngle;
    private int hp;
    private int maxHp;

    private final Vector2 POSITION_BODY;
    private final Vector2 POSITION_TRACKS;
    private final Vector2 POSITION_TURRET;
    private final Vector2 POSITION_CENTER_TANK;
    private static final float ROTATE_TURRET_V = 90.0f;
    private static final float POWER_OF_TURRET = 400.0f;

    public Tank(MainGameClass game, Vector2 position) {
        this.game = game;
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
        //Control angle turret with keyboard
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            rotateTurret(1, dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            rotateTurret(-1, dt);
        }

        //shot
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            //Bullet shows on end of turret. Bullet uses the turret angle.
            float BulletPositionX = POSITION_TURRET.x + 48 + 28 * (float)Math.cos(Math.toRadians(turretAngle));
            float BulletPositionY = POSITION_TURRET.y + 7 + 28 * (float)Math.sin(Math.toRadians(turretAngle));

            //Bullet velocity
            float BulletVelocityX = POWER_OF_TURRET * (float)Math.cos(Math.toRadians(turretAngle));
            float BulletVelocityY = POWER_OF_TURRET * (float)Math.sin(Math.toRadians(turretAngle));


            game.getBulletEmitter().setup(BulletPositionX, BulletPositionY, BulletVelocityX, BulletVelocityY);
        }
    }
}
