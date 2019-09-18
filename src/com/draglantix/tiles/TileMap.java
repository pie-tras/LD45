package com.draglantix.tiles;

import org.joml.Vector2f;
import org.joml.Vector2i;

import com.draglantix.util.Functions;
import com.draglantix.world.WorldConfig;

public class TileMap {

	private Tile[][] map;

	public TileMap(Vector2f mapCenter, Vector2i size) {
		map = new Tile[size.x][size.y];

		for(int x = 0; x < size.x; x++) {
			for(int y = 0; y < size.y; y++) {
				int id = Functions.rand.nextInt(3);
				Vector2f pos = new Vector2f((x - ((size.x / 2) - mapCenter.x)) * WorldConfig.TILE_SIZE.x,
						(y - ((size.y / 2) - mapCenter.x)) * WorldConfig.TILE_SIZE.y);
				Tile t = new Tile(TileData.getTile(id).getTexture(), pos, TileData.getTile(id).isSolid());
				map[x][y] = t;
			}
		}
	}

	public Tile getTile(int x, int y) {
		return map[x][y];
	}

}
