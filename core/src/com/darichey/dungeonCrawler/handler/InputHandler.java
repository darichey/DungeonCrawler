package com.darichey.dungeonCrawler.handler;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
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
        camera.unproject(touchPos);
        System.out.println("[" + Math.round(touchPos.x) + ", " + Math.round(touchPos.y) + "]");

        return false;
    }
}
