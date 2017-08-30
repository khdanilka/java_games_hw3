package ru.geekbrains.java_games.screens.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekuniversity.engine.math.Rect;


public class Close extends Button {

    public Close(TextureRegion region, float width) {
        super(region);
        setWidthProportion(width);
    }

    @Override
    public void resize(Rect worldBounds) {
        float delta = getHalfDiag();
        float posX = worldBounds.getRight() - delta;
        float posY = worldBounds.getBottom() + delta;
        pos.set(posX, posY);
    }

}
