package ru.geekbrains.java_games.screens.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.java_games.screens.buttons.Close;
import ru.geekbrains.java_games.screens.buttons.Play;
import ru.geekbrains.java_games.screens.stars.Star;
import ru.geekuniversity.engine.Base2DScreen;
import ru.geekuniversity.engine.Sprite2DTexture;
import ru.geekuniversity.engine.math.Rect;
import ru.geekuniversity.engine.math.Rnd;

import static com.badlogic.gdx.Input.Keys.M;

public class MenuScreen extends Base2DScreen {

    private static final float STAR_WIDTH = 0.01f;
    private static final float PlAY_WIDTH = 0.2f;
    private static final float CLOSE_WIDTH = 0.170f;
    private static final int STAR_COUNT = 200;

    private Sprite2DTexture textureBackground;
    private TextureAtlas atlas;
    private Background background;
    private Star[] stars;
    private Play playButton;
    private Close closeButton;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        textureBackground = new Sprite2DTexture("textures/bg.png");
        atlas = new TextureAtlas("textures/mainAtlas.pack");
        background = new Background(new TextureRegion(textureBackground));
        TextureRegion regionStar = atlas.findRegion("star");
        stars = new Star[STAR_COUNT];
        for(int i = 0; i < STAR_COUNT; i++) {
            float vx = Rnd.nextFloat(-0.005f, 0.005f);
            float vy = Rnd.nextFloat(-0.05f, -0.1f);
            float starWidth = STAR_WIDTH * Rnd.nextFloat(0.75f, 1f);
            stars[i] = new Star(regionStar, vx, vy, starWidth);
        }
        regionStar = atlas.findRegion("btPlay");
        playButton = new Play(regionStar,PlAY_WIDTH);

        regionStar = atlas.findRegion("btExit");
        closeButton = new Close(regionStar,CLOSE_WIDTH);

    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        for(int i = 0; i < STAR_COUNT; i++) {
            stars[i].resize(worldBounds);
        }
        playButton.resize(worldBounds);
        closeButton.resize(worldBounds);
    }

    @Override
    protected void touchDown(Vector2 touch, int pointer) {
        System.out.println(touch);
        for(int i = 0; i < STAR_COUNT; i++) {
            stars[i].touchDown(touch, pointer);
        }
        playButton.touchDown(touch,pointer);
        closeButton.touchDown(touch,pointer);
    }

    @Override
    protected void touchUp(Vector2 touch, int pointer) {
        if (playButton.touchUp(touch,pointer)) System.out.println("Пользователь нажал плей");;
        if (closeButton.touchUp(touch,pointer)) System.out.println("Пользователь нажал выход");;
    }

    @Override
    public void render (float delta) {
        update(delta);
        draw();
    }

    private void update(float deltaTime) {
        for(int i = 0; i < STAR_COUNT; i++) {
            stars[i].update(deltaTime);
        }
    }

    private void draw() {
        Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        for(int i = 0; i < STAR_COUNT; i++) {
            stars[i].draw(batch);
        }
        playButton.draw(batch);
        closeButton.draw(batch);
        batch.end();
    }

    @Override
    public void dispose () {
        textureBackground.dispose();
        atlas.dispose();
        super.dispose();
    }
}
