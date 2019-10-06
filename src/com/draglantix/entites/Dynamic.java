package com.draglantix.entites;

import org.joml.Vector2f;

import com.draglantix.flare.audio.Source;
import com.draglantix.flare.collision.Collisions;
import com.draglantix.flare.collision.Polygon;
import com.draglantix.flare.textures.Texture;
import com.draglantix.flare.util.Functions;
import com.draglantix.tiles.Tile;
import com.draglantix.world.World;

public abstract class Dynamic extends Entity{

	protected Source source;
	
	protected boolean alive = true;
	protected float health = 1f;
	protected float speed = 1f;

	protected Polygon bounds;
	
	public Dynamic(Texture texture, Vector2f position, Vector2f scale) {
		super(texture, position, scale);
		source = new Source(10, 10);
		this.bounds = Functions.generateSquareBound(position, new Vector2f(scale.x/2, scale.y/2), true);
	}
	
	@Override
	public void tick() {
		source.setPosition(position);
		alive = checkLiving();
	}
	
	private boolean checkLiving() {
		return health > 0f;
	}
	
	private void checkForCollisions() {
		if(bounds.getIsMoveable()) {
			for(Dynamic entity : EntityManager.dynamics) {
				if(!this.equals(entity) && entity.getBounds() != null) {
					bounds.add(Collisions.testCollision(bounds, entity.getBounds()));
				}
			}
			for(Tile tile : World.activeTiles) {
				if(tile.getBounds() != null) {
					bounds.add(Collisions.testCollision(bounds, tile.getBounds()));
				}
			}
		}
	}

	public void move(Vector2f dir) {
		if(bounds != null) {
			bounds.add(dir);
			checkForCollisions();
			position.set(bounds.getPosition());
		} else {
			position.add(dir);
		}

	}
	
	public Polygon getBounds() {
		return bounds;
	}
	
	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
}
