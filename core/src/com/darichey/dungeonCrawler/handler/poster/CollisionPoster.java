package com.darichey.dungeonCrawler.handler.poster;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.EntityBlock;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.event.EventManager;
import com.darichey.dungeonCrawler.event.world.entity.EventDynamicCollideDynamic;
import com.darichey.dungeonCrawler.event.world.entity.EventDynamicCollideBlock;
import com.darichey.dungeonCrawler.handler.HandlerBase;
import com.darichey.dungeonCrawler.world.World;

/**
 * Posts collision events to the event manager
 */
public class CollisionPoster extends HandlerBase
{
    private World world;

    public CollisionPoster(World world)
    {
        this.world = world;
    }

    @Override
    public void update()
    {
        for (DynamicEntity firstEntity : world.getDynamicEntities())
        {
            for (DynamicEntity secondEntity : world.getDynamicEntities())
            {
                if (firstEntity != secondEntity)
                {
                    Rectangle firstBounds = firstEntity.getBounds();
                    Rectangle secondBounds = secondEntity.getBounds();
                    if (firstBounds.overlaps(secondBounds))
                    {
                        EventManager.post(new EventDynamicCollideDynamic(firstEntity, secondEntity));
                    }
                }
            }
        }

        for (DynamicEntity dynamic : world.getDynamicEntities())
        {
            for (Vector2 blockPos : world.getBlockPositions())
            {
                EntityBlock block = (EntityBlock) world.getEntityAt(blockPos);
                Rectangle dynamicBounds = dynamic.getBounds();
                Rectangle blockBounds = new Rectangle(blockPos.x, blockPos.y, block.width, block.height);

                if (dynamicBounds.overlaps(blockBounds))
                {
                    EventManager.post(new EventDynamicCollideBlock(dynamic, blockPos));
                }
            }
        }
    }
}
