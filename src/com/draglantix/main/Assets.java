package com.draglantix.main;

import org.joml.Vector2f;

import com.draglantix.flare.graphics.Camera;
import com.draglantix.flare.graphics.Graphics;
import com.draglantix.flare.textures.Font;
import com.draglantix.flare.textures.SpriteSheet;
import com.draglantix.flare.textures.Texture;
import com.draglantix.world.World;

public class Assets {

	public static Camera camera;
	public static Font font;

	public static Texture sheep;

	public static SpriteSheet tiles;

	public static Texture grass, stone, water, nothing;
	
	public static World world;

	public static void init(Graphics g) {

		camera = new Camera(new Vector2f(0, 0), 0, 0, .07f, g);
		font = new Font(new SpriteSheet("font.png"), 8);
		g.setCamera(camera);
		g.setScale(3);

		sheep = new Texture("sheep.png");

		tiles = new SpriteSheet("tiles.png");
		grass = new Texture(tiles.crop(new Vector2f(0, 0), new Vector2f(16, 16)));
		stone = new Texture(tiles.crop(new Vector2f(16, 0), new Vector2f(16, 16)));
		water = new Texture(tiles.crop(new Vector2f(0, 16), new Vector2f(16, 16)));
		nothing = new Texture(tiles.crop(new Vector2f(16, 16), new Vector2f(16, 16)));

		world = new World();
		
	}
}
