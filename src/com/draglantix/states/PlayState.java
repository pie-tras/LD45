package com.draglantix.states;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.graphics.Graphics;
import com.draglantix.main.Assets;
import com.draglantix.tiles.TileData;
import com.draglantix.tiles.TileMap;
import com.draglantix.util.Color;
import com.draglantix.window.Window;

public class PlayState extends GameState {

	private Vector2f target = new Vector2f(0, 0);

	private TileMap map;

	public PlayState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
		TileData.init();
		map = new TileMap(new Vector2f(0, 0), g);
	}

	@Override
	public void tick() {
//		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
//			GameStateManager.setState(States.MENU);
//		}
		
		updateCamera();
	}

	@Override
	public void render() {
		g.drawMode(g.DRAW_WORLD);
		map.render(g);
		g.drawImage(Assets.sheep, target, new Vector2f(16, 16), new Vector2f(0, 0), new Color(255, 255, 255, 1));
	}

	public void updateCamera() {
		float speed = 5f;
		
		Vector2f destination = new Vector2f(0, 0);

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)) {
			destination.x += 1;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A)) {
			destination.x -= 1;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_W)) {
			destination.y += 1;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_S)) {
			destination.y -= 1;
		}
		
		if(destination.length() != 0) {
			target.add(destination.normalize(speed));
		}

		Assets.camera.move(target);
	}

}
