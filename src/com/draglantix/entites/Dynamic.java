package com.draglantix.entites;

import org.joml.Vector2f;

import com.draglantix.flare.audio.Source;
import com.draglantix.flare.textures.Texture;

public abstract class Dynamic extends Entity{

	protected Source source;
	
	protected boolean alive = true;
	protected float health = 1f;
	
	public Dynamic(Texture texture, Vector2f position, Vector2f scale) {
		super(texture, position, scale);
		source = new Source(10, 10);
	}
	
	@Override
	public void tick() {
		source.setPosition(position);
		alive = checkLiving();
	}
	
	private boolean checkLiving() {
		return health > 0f;
	}

}
