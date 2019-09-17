package com.draglantix.states;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.graphics.Graphics;
import com.draglantix.main.Assets;
import com.draglantix.util.Color;
import com.draglantix.window.Window;
import com.draglantix.world.TileLib;
import com.draglantix.world.TileMap;

public class PlayState extends GameState{

	private Vector2f target = new Vector2f(0, 0);
	
	private TileMap map;
	
	public PlayState(Graphics g) {
		super(g);
		new TileLib();
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
		float speed = 10f;

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)) {
			target.x += speed;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A)) {
			target.x -= speed;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_W)) {
			target.y += speed;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_S)) {
			target.y -= speed;
		}

		Assets.camera.move(target);
	}

}

