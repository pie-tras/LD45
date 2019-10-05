package com.draglantix.world;

import org.joml.Vector2f;

import com.draglantix.entites.EntityManager;
import com.draglantix.flare.graphics.Graphics;
import com.draglantix.flare.util.Reader;
import com.draglantix.flare.window.Window;
import com.draglantix.main.Assets;
import com.draglantix.tiles.TileData;
import com.draglantix.tiles.TileMap;
import com.draglantix.utils.DragonMath;

public class World {

	private TileMap map;

	public World() {

	}

	public void init() {
		TileData.init();
		map = new TileMap(parseTileMap("maps/map.dat"), new Vector2f(0, 0), WorldConfig.WORLD_SIZE);
	}
	
	public static int[][] parseTileMap(String path) {
		String raw = Reader.loadFileAsString(path);
		String[] tokens = raw.split("\\s+");
		int size = (int) Math.sqrt(tokens.length);
		int[][] ids = new int[size][size];
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				ids[x][y] = Reader.parseInt(tokens[x+y*(size)]);
			}
		}
		return ids;
	}

	public void tick() {
		EntityManager.tick();
	}

	public void render(Graphics g) {
		renderTiles(g);
		EntityManager.render(g);
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
				if(x < WorldConfig.WORLD_SIZE.x && y < WorldConfig.WORLD_SIZE.y) {
					map.getTile(x, y).render(g);
				}
			}
		}
	}

}
