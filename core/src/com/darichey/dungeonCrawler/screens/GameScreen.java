package com.darichey.dungeonCrawler.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.darichey.dungeonCrawler.event.EventManager;
import com.darichey.dungeonCrawler.gui.GuiHUD;
import com.darichey.dungeonCrawler.handler.*;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.init.Items;
import com.darichey.dungeonCrawler.render.GuiRenderer;
import com.darichey.dungeonCrawler.render.WorldRenderer;
import com.darichey.dungeonCrawler.world.World;

/**
 * Main playing screen for the game
 */
public class GameScreen extends ScreenAdapter {
	private World world;
	private WorldRenderer worldRenderer;
	private GuiRenderer guiRenderer;
	private Stage stage;
	private HandlerBase movementHandler;
	private HandlerBase collisionHandler;
	private InputHandler inputHandler;

	public static Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

	public GameScreen() {
		Entities.init();
		Items.init();

		world = new World();
		worldRenderer = new WorldRenderer(world);
		guiRenderer = new GuiRenderer();
		movementHandler = new MovementHandler(world.player);
		collisionHandler = new CollisionHandler(world);
		inputHandler = new InputHandler(world, worldRenderer.camera);
		stage = new Stage();

		guiRenderer.setGui(new GuiHUD(stage, world.player));

		EventManager.register(new EventListener());

		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputHandler);
		multiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(multiplexer);
	}

	public void update(float delta) {
		world.update();
		movementHandler.update(delta);
		collisionHandler.update(delta);
		inputHandler.update();
	}

	@Override
	public void render(float delta) {
		update(delta);
		worldRenderer.render();
		guiRenderer.render();
	}
}
