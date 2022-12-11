package entity;

import core.Position;
import core.Size;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;
    protected String objectName;

    public GameObject() {
        this.position = new Position(50, 50);
        this.size = new Size(50, 50);
    }

    public abstract void update();
    public abstract Image getSprite();

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public String getObjectName() {
        return objectName;
    }
}