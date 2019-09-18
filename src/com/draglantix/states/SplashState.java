package com.draglantix.states;

import org.joml.Vector2f;
import org.lwjgl.glfw.GLFW;

import com.draglantix.graphics.Graphics;
import com.draglantix.main.Assets;
import com.draglantix.util.Color;
import com.draglantix.window.Window;

public class SplashState extends GameState {

	public SplashState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
	}

	@Override
	public void tick() {
		if(Window.getInput().isKeyPressed(GLFW.GLFW_KEY_SPACE)) {
			gsm.setState(States.INTRO);
		}
	}

	@Override
	public void render() {
		g.drawImage(Assets.sheep, new Vector2f(0, 0), new Vector2f(16, 16), new Vector2f(0, 0),
				new Color(0, 255, 255, 1));
	}

}
