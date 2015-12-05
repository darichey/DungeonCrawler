package com.darichey.dungeonCrawler.handler;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.entity.block.BlockBase;
import com.darichey.dungeonCrawler.world.World;

/**
 * Posts collision events to the event manager
 */
public class CollisionHandler extends HandlerBase {
    private World world;

    public CollisionHandler(World world) {
        this.world = world;
    }

    @Override
    public void update(float deltaTime) {
        for (DynamicEntity firstEntity : world.getDynamicEntities()) {
            for (DynamicEntity secondEntity : world.getDynamicEntities()) {
                if (firstEntity != secondEntity) {
                    Rectangle firstBounds = firstEntity.getBounds();
                    Rectangle secondBounds = secondEntity.getBounds();
                    if (firstBounds.overlaps(secondBounds)) {
                        // FIXME: So broken D:
                        //EventManager.post(new EventDynamicCollideDynamic(firstEntity, secondEntity));
                    }
                }
            }
        }

        for (DynamicEntity dynamic : world.getDynamicEntities()) {
            for (Vector2 blockPos : world.getBlockPositions()) {
                BlockBase block = (BlockBase) world.getEntityAt(blockPos);
                Rectangle dynamicBounds = dynamic.getBounds();
                Rectangle blockBounds = new Rectangle(blockPos.x, blockPos.y, block.width, block.height);

                if (dynamicBounds.overlaps(blockBounds)) {
                    // FIXME: So broken D:
                    //EventManager.post(new EventDynamicCollideBlock(dynamic, blockPos));

                    float overlapX = getOverlap1D(dynamicBounds.x, dynamicBounds.x + dynamicBounds.width, blockBounds.x, blockBounds.x + blockBounds.width);
                    float overlapY = getOverlap1D(dynamicBounds.y, dynamicBounds.y + dynamicBounds.height, blockBounds.y, blockBounds.y + blockBounds.height);

                    if (overlapX < overlapY) {
                        if (dynamic.getVelocity().x < 0) {
                            dynamic.getPos().add(overlapX, 0);
                        } else {
                            dynamic.getPos().sub(overlapX, 0);
                        }
                        dynamic.setVelocityX(0);
                    } else {
                        if (dynamic.getVelocity().y < 0) {
                            dynamic.getPos().add(0, overlapY);
                        } else {
                            dynamic.getPos().sub(0, overlapY);
                        }
                        dynamic.setVelocityY(0);
                    }
                }
            }
        }
    }

    private float getOverlap1D(float min1, float max1, float min2, float max2) {
        return Math.max(0, Math.min(max1, max2) - Math.max(min1, min2));
    }
}
