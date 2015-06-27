package com.darichey.dungeonCrawler.entity.base;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class DynamicEntity extends GameEntity
{
    private Vector2 pos = new Vector2();
    private Vector2 prevPos = new Vector2();

    public Vector2 getPrevPos()
    {
        return prevPos;
    }

    public void setPrevPos(Vector2 prevPos)
    {
        this.prevPos.set(prevPos);
    }

    public Vector2 getPos()
    {
        return pos;
    }

    public void setPos(Vector2 pos)
    {
        setPrevPos(getPos());
        this.pos = pos;
    }

    public void setPosX(float posX)
    {
        setPos(new Vector2(posX, getPos().y));
    }

    public void setPosY(float posY)
    {
        setPos(new Vector2(getPos().x, posY));
    }

    //TODO
    public Vector2 getGridPosition()
    {
        return null;
    }
}
