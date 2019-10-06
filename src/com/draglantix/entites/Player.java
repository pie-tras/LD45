package com.draglantix.entites;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.flare.textures.Texture;
import com.draglantix.flare.window.Window;

public class Player extends Dynamic{

	private Vector2f destination = new Vector2f(0, 0);
	
	public Player(Texture texture, Vector2f position, Vector2f scale) {
		super(texture, position, scale);
		setSpeed(5f);
	}

	@Override
	public void tick() {
		super.tick();
		
		destination.x = 0;
		destination.y = 0;
		
		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_D)) {
			destination.x += speed;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_A)) {
			destination.x -= speed;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_W)) {
			destination.y += speed;
		}

		if(Window.getInput().isKeyDown(GLFW.GLFW_KEY_S)) {
			destination.y -= speed;
		}
		
		if(destination.length() != 0) {
			move(destination.normalize(speed), true);
		}	
	}
	
}
