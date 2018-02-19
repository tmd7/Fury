package com.fury.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int CELL_SIZE = 1;

    private Texture textureGround;
    private byte[][] data;

    public Map() {
        this.textureGround = new Texture("ground01.png");
        this.data = new byte[WIDTH][HEIGHT];
        this.generate();
    }

    //Generate ground
    public void generate() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT/4; j++) {
                data[i][j] = 1;
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (data[i][j] == 1) {
                    batch.draw(textureGround, i * CELL_SIZE, j * CELL_SIZE, 0, 0, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }

    public void update(float dt) {

    }
}
