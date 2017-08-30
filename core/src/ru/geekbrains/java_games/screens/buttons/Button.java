package ru.geekbrains.java_games.screens.buttons;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekuniversity.engine.math.Rect;
import ru.geekuniversity.engine.math.Rnd;
import ru.geekuniversity.engine.sprites.Sprite;


public class Button extends Sprite {

    private boolean scaleDone;

    protected Button(TextureRegion region) {
        super(region);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if(isMe(touch)) {
            // System.out.println("touchDown случился на кнопке");
            scaleButton();
        }
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if(isMe(touch)) {
            if (this.isScaleDone()) {
                //System.out.println("touchUp случился на кнопке");
                reScaleButton();
                return true;
            }
        } else if (this.isScaleDone()) reScaleButton();
        return false;
    }

    public void scaleButton(){
        setHeight(getHeight()*0.75f);
        setWidth(getWidth()*0.75f);
        scaleDone = true;
    }

    public void reScaleButton(){
        setHeight(getHeight()/0.75f);
        setWidth(getWidth()/0.75f);
        scaleDone = false;
    }

    public boolean isScaleDone() {
        return scaleDone;
    }

    protected float getHalfDiag(){
        return (float) Math.pow(Math.pow(getHalfWidth(),2) + Math.pow(getHalfHeight(),2), 0.5);
    }

}
