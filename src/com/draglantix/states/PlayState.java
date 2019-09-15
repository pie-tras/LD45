package com.draglantix.states;

import org.lwjgl.glfw.GLFW;

import com.draglantix.graphics.Graphics;
import com.draglantix.window.Window;

public class PlayState extends GameState{

	public PlayState(Graphics g) {
		super(g);
	}

	@Override
	public void tick() {
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			GameStateManager.setState(States.MENU);
		}
	}

	@Override
	public void render() {
		
	}

}

