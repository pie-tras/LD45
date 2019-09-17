package com.draglantix.world;

import java.util.HashMap;
import java.util.Map;

import com.draglantix.main.Assets;

public class TileLib {
	
	public static final Map<Integer, Tile> TILE_INDEX = new HashMap<Integer, Tile>();
	
	public static final Tile GRASS = new Tile(Assets.grass, false);
	public static final Tile STONE = new Tile(Assets.stone, false);
	public static final Tile WATER = new Tile(Assets.water, false);
	public static final Tile NOTHING = new Tile(Assets.nothing, false);
	
	public TileLib() {
		TILE_INDEX.put(0, GRASS);
		TILE_INDEX.put(1, STONE);
		TILE_INDEX.put(2, WATER);
		TILE_INDEX.put(3, NOTHING);
	}
}
