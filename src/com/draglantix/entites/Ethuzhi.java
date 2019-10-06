package com.draglantix.entites;

import org.joml.Vector2f;

import com.draglantix.flare.textures.Texture;

public class Ethuzhi extends Dynamic{

	//private AI ai;
	
	public Ethuzhi(Texture texture, Vector2f position, Vector2f scale) {
		super(texture, position, scale);
		// = new AI(this);
	}
	
	@Override
	public void tick() {
		super.tick();
		//ai.wander();
	}

}
