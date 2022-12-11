package gfx;

import core.Direction;
import game.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private int updatesPerFrame;
    private int currentFrameTime;
    private int frameIndex;
    private int directionIndex;

    public AnimationManager(SpriteSet spriteSet) {
        this.spriteSet = spriteSet;
        this.updatesPerFrame = 20;
        this.frameIndex = 0;
        this.currentFrameTime = 0;
        this.directionIndex = 0;
    }

    public Image getSprite() {
        try {
            return currentAnimationSheet.getSubimage(
                    frameIndex * GamePanel.TILE_SIZE,
                    directionIndex * GamePanel.TILE_SIZE,
                    GamePanel.TILE_SIZE,
                    GamePanel.TILE_SIZE
            );
        } catch (NullPointerException e) {

        }
        return null;
    }

    public void update(Direction direction) {
        currentFrameTime++;
        directionIndex = direction.getAnimationRow();

        if(currentFrameTime >= updatesPerFrame) {
            currentFrameTime = 0;
            frameIndex++;

            if(frameIndex >= currentAnimationSheet.getWidth() / GamePanel.TILE_SIZE) {
                frameIndex = 0;
            }
        }
    }

    public void playAnimation(String name) {
        this.currentAnimationSheet = (BufferedImage) spriteSet.get(name);
    }

}
