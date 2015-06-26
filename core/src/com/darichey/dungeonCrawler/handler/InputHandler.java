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
        Vector3 pixelPos = camera.unproject(touchPos);
        System.out.println(pixelPos.x + ", " + pixelPos.y);
        Vector2 worldPos = new Vector2((float)Math.floor(pixelPos.x / 16), (float)Math.floor(pixelPos.y / 16));
        System.out.println(worldPos.x + ", " + worldPos.y);
        if (world.getEntityAt(worldPos) == null)
        {

        }
        System.out.println(world.getEntityAt(worldPos).getName());
        return false;
    }
}