package com.draglantix.states;

import org.lwjgl.glfw.GLFW;

import com.draglantix.graphics.Graphics;
import com.draglantix.window.Window;

public class IntroState extends GameState {

	public IntroState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
	}

	@Override
	public void tick() {
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			gsm.setState(States.MENU);
		}
	}

	@Override
	public void render() {

	}

}
