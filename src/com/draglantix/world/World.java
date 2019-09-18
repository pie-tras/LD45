package com.draglantix.world;

import org.joml.Vector2f;

import com.draglantix.graphics.Graphics;
import com.draglantix.main.Assets;
import com.draglantix.tiles.TileData;
import com.draglantix.tiles.TileMap;
import com.draglantix.utils.DragonMath;
import com.draglantix.window.Window;

public class World {

	private TileMap map;

	public World() {

	}

	public void init() {
		TileData.init();
		map = new TileMap(new Vector2f(0, 0), WorldConfig.WORLD_SIZE);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		renderTiles(g);
	}

	public void renderTiles(Graphics g) {
		Vector2f initial = new Vector2f(
				Assets.camera.getPosition().x / WorldConfig.TILE_SIZE.x / g.getScale()
						- Window.getWidth() / 2 / WorldConfig.TILE_SIZE.x / g.getScale() + WorldConfig.WORLD_SIZE.x / 2,
				Assets.camera.getPosition().y / WorldConfig.TILE_SIZE.y / g.getScale()
						- Window.getHeight() / 2 / WorldConfig.TILE_SIZE.y / g.getScale()
						+ WorldConfig.WORLD_SIZE.y / 2);
		Vector2f end = new Vector2f(
				Assets.camera.getPosition().x / WorldConfig.TILE_SIZE.x / g.getScale()
						+ Window.getWidth() / 2 / WorldConfig.TILE_SIZE.x / g.getScale() + WorldConfig.WORLD_SIZE.x / 2,
				Assets.camera.getPosition().y / WorldConfig.TILE_SIZE.y / g.getScale()
						+ Window.getHeight() / 2 / WorldConfig.TILE_SIZE.y / g.getScale()
						+ WorldConfig.WORLD_SIZE.y / 2);

		for(int x = DragonMath.floor(Math.max(initial.x - 1, 0)); x < DragonMath.ceil(Math.min(end.x + 1, 100)); x++) {
			for(int y = DragonMath.floor(Math.max(initial.y - 1, 0)); y < DragonMath
					.ceil(Math.min(end.y + 1, 100)); y++) {
				map.getTile(x, y).render(g);
			}
		}
	}

}
