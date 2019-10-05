package com.draglantix.world;

import org.joml.Vector2f;

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
	
	//**Screams of pain** (Needs work)
	public static int[][] parseTileMap(String path) {
		String raw = Reader.loadFileAsString(path);
		String[] lines = raw.split("\n");
		String[][] tokens = new String[lines.length][lines.length];
		for(int i = 0; i < tokens.length)) {
			tokens[][] = raw.split("\\s+");
		}
		int[] ids = new int[tokens.length];
		for(int i = 0; i < tokens.length; i++) {
			ids[i] = Reader.parseInt(tokens[i]);
		}
		return ids;
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
