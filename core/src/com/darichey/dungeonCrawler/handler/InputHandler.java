package com.darichey.dungeonCrawler.handler;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.world.World;

public class InputHandler extends InputAdapter
{
    private World world;
    private OrthographicCamera camera;

    public InputHandler(World world, OrthographicCamera camera)
    {
        this.world = world;
        this.camera = camera;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        Vector3 touchPos = new Vector3(screenX, screenY, 0);
        Vector3 worldCoords = camera.unproject(touchPos);
        GameEntity entity = world.getEntityAt(new Vector2(worldCoords.x, worldCoords.y));
        if (entity == null)
        {
            System.out.println("null at [" + Math.round(worldCoords.x) + ", " + Math.round(worldCoords.y) + "]");
        }
        else
        {
            System.out.println(entity.getName() + " at [" + entity.getPos().x + ", " + entity.getPos().y + "]");
        }

        return false;
    }
}
