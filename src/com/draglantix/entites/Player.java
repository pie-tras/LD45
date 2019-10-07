package com.draglantix.entites;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.flare.textures.Texture;
import com.draglantix.flare.util.Functions;
import com.draglantix.flare.window.Window;
import com.draglantix.main.Assets;

public class Player extends Dynamic{

	private Vector2f destination = new Vector2f(0, 0);
	
	public Player(Texture texture, Vector2f position, Vector2f scale) {
		super(texture, position, scale);
		setSpeed(0.5f);
		source.setVolume(0.1f);
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
			if(!source.isPlaying()) {
				int step = Functions.rand.nextInt(3);
				if(step == 0) {
					source.play(Assets.steps1);
				}else if(step == 1) {
					source.play(Assets.steps2);
				}else {
					source.play(Assets.steps3);
				}
			}
		}
		
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_J)) {
			setSpeed(1.5f);
			source.setVolume(1.2f);
			source.setPitch(2f);
		}
		
		if(Window.getInput().isKeyReleased(GLFW.GLFW_KEY_J)) {
			setSpeed(0.5f);
			source.setVolume(0.1f);
			source.setPitch(1f);
		}
	}
	
}
