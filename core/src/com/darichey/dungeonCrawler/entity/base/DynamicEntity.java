package com.darichey.dungeonCrawler.entity.base;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * The base for dynamic entities. Dynamic entities are entities that can change position
 */
public abstract class DynamicEntity extends GameEntity
{
    /**
     * Current position of the entity *
     */
    private Vector2 pos = new Vector2();

    public Vector2 getPos()
    {
        return pos;
    }

    public void setPos(Vector2 pos)
    {
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

    public Rectangle getBounds()
    {
        return new Rectangle(getPos().x, getPos().y, width, height);
    }
}
