package com.darichey.dungeonCrawler.entity.base;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class LivingEntity extends GameEntity
{
    private Vector2 prevPos = new Vector2();

    public Vector2 getPrevPos()
    {
        return prevPos;
    }

    public void setPrevPos(Vector2 prevPos)
    {
        this.prevPos.set(prevPos);
    }

    @Override
    public void setPos(Vector2 pos)
    {
        setPrevPos(getPos());
        setBounds(new Rectangle(pos.x, pos.y, getBounds().width, getBounds().height));
        super.setPos(pos);
    }
}
