package com.draglantix.world;

import org.joml.Vector2f;

import com.draglantix.graphics.Graphics;
import com.draglantix.util.Functions;

public class TileMap {

	private Tile[][] map = new Tile[WorldConfig.WORLD_SIZE.x][WorldConfig.WORLD_SIZE.y];
	
	public TileMap(Vector2f mapCenter, Graphics g) {
		for(int x = 0; x < WorldConfig.WORLD_SIZE.x; x++) {
			for(int y = 0; y < WorldConfig.WORLD_SIZE.y; y++) {
				int id = Functions.rand.nextInt(3);
				Vector2f pos = new Vector2f((x - ((WorldConfig.WORLD_SIZE.x/2)-mapCenter.x)) * WorldConfig.TILE_SIZE.x * g.getScale(), 
						(y - ((WorldConfig.WORLD_SIZE.x/2)-mapCenter.x)) * WorldConfig.TILE_SIZE.y * g.getScale());
				Tile t = new Tile(TileLib.TILE_INDEX.get(id), pos);
				map[x][y] = t;
			}
		}
	}
	
	public void render(Graphics g) {
		for(int x = 0; x < WorldConfig.WORLD_SIZE.x; x++) {
			for(int y = 0; y < WorldConfig.WORLD_SIZE.y; y++) {
				Tile t = map[x][y];
				t.render(g);
			}
		}
	}

}
