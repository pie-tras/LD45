package com.draglantix.states;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.flare.graphics.Graphics;
import com.draglantix.flare.util.Color;
import com.draglantix.flare.window.Window;
import com.draglantix.main.Assets;

public class PlayState extends GameState {

	private Vector2f target = new Vector2f(0, 0);


	public PlayState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
		Assets.world.init();
	}

	@Override
	public void tick() {
		Assets.world.tick();
		updateCamera();
	}

	@Override
	public void render() {
		g.drawMode(g.DRAW_WORLD);
		Assets.world.render(g);
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
