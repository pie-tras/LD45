package com.draglantix.entites;

import org.joml.Vector2f;

import com.draglantix.flare.textures.Texture;

public class Sheep extends Dynamic{

	private AI ai;
	
	public Sheep(Texture texture, Vector2f position, Vector2f scale) {
		super(texture, position, scale);
		ai = new AI(this);
	}
	
	@Override
	public void tick() {
		super.tick();
		ai.wander();
	}

}
