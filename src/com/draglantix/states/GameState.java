package com.draglantix.states;

import com.draglantix.graphics.Graphics;

public abstract class GameState {

	protected Graphics g;
	
	public GameState(Graphics g) {
		this.g = g;
	}
	
	public abstract void tick();
	public abstract void render();
	
	public void start() {}
	public void stop() {}
	
}
