package com.fury.game;
/*
* That class generate and rendered bullets.
*/

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class BulletEmitter {
    private Texture bulletTexture;
    private Bullet[] bullets;

    public BulletEmitter() {
        bulletTexture = new Texture("tank_bullet2.png");
        bullets = new Bullet[100];

        //Create the bullets in constructor
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
    }

    public Bullet[] getBullets() {
        return bullets;
    }

    //if bullet is active - draw
    public void render(SpriteBatch batch){
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) {
                batch.draw(bulletTexture, bullets[i].getPosition().x, bullets[i].getPosition().y);
            }
        }
    }

    //if bullet is active - update
    public void update(float dt) {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].isActive()) {
                bullets[i].update(dt);
            }
        }
    }

    //if bullet isn't active, activate it
    public void setup(float x, float y, float vx, float vy) {
        for (int i = 0; i < bullets.length; i++) {
            if (!bullets[i].isActive()) {
                bullets[i].active(x, y, vx, vy);
                break;
            }
        }
    }
}
