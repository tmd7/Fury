package com.fury.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet {
    private Vector2 position;
    private Vector2 velocity;
    private boolean active;
    private float angle;

    public Bullet() {
        position = new Vector2(0, 0);
        velocity = new Vector2(0, 0);
        active = false;
        angle = 0.0f;
    }

    public void active(float x, float y, float vx, float vy) {
        position.set(x, y);
        velocity.set(x, y);
        active = true;
    }

    public void deactivate() {
        active = false;
    }

    public void update(float dt) {
        // x += vx *dt;
        // y += vy * dt;
        position.mulAdd(velocity, dt);
        angle = velocity.angle();
        velocity.y -= MainGameClass.GLOBAL_GRAVITY * dt;
    }
}
