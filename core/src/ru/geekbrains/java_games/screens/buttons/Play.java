package ru.geekbrains.java_games.screens.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.geekuniversity.engine.math.MatrixUtils;
import ru.geekuniversity.engine.math.Rect;
import ru.geekuniversity.engine.math.Rnd;

public class Play extends Button {


    public Play(TextureRegion region, float width) {
        super(region);
        setWidthProportion(width);
    }

    @Override
    public void resize(Rect worldBounds) {
        float delta = getHalfDiag();
        float posX = worldBounds.getLeft() + delta;
        float posY = worldBounds.getBottom() + delta;
        pos.set(posX, posY);
    }

}
