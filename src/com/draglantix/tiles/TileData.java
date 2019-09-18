package com.draglantix.tiles;

import java.util.HashMap;
import java.util.Map;

import com.draglantix.main.Assets;
import com.draglantix.textures.Texture;

public class TileData {
	public static Map<Integer, TileData> tileIndex;
	
	public static TileData grass, stone, water, empty;
	
	private Texture texture;
	private boolean isSolid;
	
	public TileData(Texture texture, boolean isSolid) {
		this.texture = texture;
		this.isSolid = isSolid;
	}
	
	public Texture getTexture() {
		return texture;
	}
	
	public boolean isSolid() {
		return isSolid;
	}
	
	public static void init() {
		tileIndex = new HashMap<Integer, TileData>();
		
		grass = new TileData(Assets.grass, false);
		stone = new TileData(Assets.stone, false);
		water = new TileData(Assets.water, false);
		empty = new TileData(Assets.nothing, false);
		
		tileIndex.put(0, grass);
		tileIndex.put(1, stone);
		tileIndex.put(2, water);
		tileIndex.put(3, empty);
	}
	
	public static TileData getTile(int index) {
		return tileIndex.get(index);
	}
}