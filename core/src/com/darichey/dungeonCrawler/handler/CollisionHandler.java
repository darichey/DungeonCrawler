package com.darichey.dungeonCrawler.handler;

import com.darichey.dungeonCrawler.entity.EntityPlayer;
import com.darichey.dungeonCrawler.entity.EntityWall;
import com.darichey.dungeonCrawler.world.World;

public class CollisionHandler extends HandlerBase
{
    private World world;

    public CollisionHandler(World world)
    {
        this.world = world;
    }

    @Override
    public void update()
    {
        EntityPlayer player = world.player;

        /*
        REDO WITH TILE MAP
        for (EntityWall wall : world.getWalls())
        {
            if (player.getBounds().overlaps(wall.getBounds()))
            {
                System.out.println("PREV: " + player.getPrevPos());
                System.out.println("CUR: " + player.getPos());
                //player.setPos(player.getPrevPos());
                //player.setPosY(player.getPos().y + 1);
            }
        }
        */
    }
}
