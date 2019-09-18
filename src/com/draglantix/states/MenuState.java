package com.draglantix.states;

import org.lwjgl.glfw.GLFW;

import com.draglantix.graphics.Graphics;
import com.draglantix.window.Window;

public class MenuState extends GameState {

	public MenuState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
	}

	@Override
	public void tick() {
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			gsm.setState(States.PLAY);
		}
	}

	@Override
	public void render() {

	}

}
