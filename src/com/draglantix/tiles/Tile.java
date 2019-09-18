package com.draglantix.tiles;

import org.joml.Vector2f;

import com.draglantix.flare.graphics.Graphics;
import com.draglantix.flare.textures.Texture;
import com.draglantix.flare.util.Color;
import com.draglantix.world.WorldConfig;

public class Tile {

	private Texture texture;
	private Vector2f position;
	private boolean solid;
	
	private Vector2f rotation = new Vector2f(0, 0);
	private Color color = new Color(255, 255, 255, 1);
	
	public Tile(Texture texture, Vector2f position, boolean solid) {
		this.texture = texture;
		this.position = position;
		this.solid = solid;
	}
	
	public void render(Graphics g) {
		g.drawImage(texture, position, WorldConfig.TILE_SIZE, rotation, color);
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public boolean isSolid() {
		return solid;
	}

}
