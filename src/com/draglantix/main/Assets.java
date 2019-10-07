package com.draglantix.main;

import org.joml.Vector2f;

import com.draglantix.flare.audio.AudioMaster;
import com.draglantix.flare.audio.Source;
import com.draglantix.flare.graphics.Camera;
import com.draglantix.flare.graphics.Graphics;
import com.draglantix.flare.textures.Animation;
import com.draglantix.flare.textures.Font;
import com.draglantix.flare.textures.SpriteSheet;
import com.draglantix.flare.textures.Texture;
import com.draglantix.world.World;

public class Assets {

	public static Camera camera;
	public static Font font;

	public static Texture sheep;

	public static SpriteSheet tiles;

	public static Texture stone1, stone2, sand, corner1,
	corner2, corner3, corner4, flat1, flat2, flat3,
	flat4, grass, bone, solid1, solid2, solid3,
	solid4, solid5, solid6, solid7, solid8, solid9, campfire;
	
	public static World world;
	
	public static Texture debug;
	
	public static Texture border, dark;
	
	public static SpriteSheet draglantix;
	public static Animation logoAnim;
	
	public static int darkloop;
	
	public static int campfireSFX, steps1, steps2, steps3;
	
	public static Source musicSource;
	
	public static Texture title, selector;

	public static SpriteSheet fire;
	public static Animation fireAnim;
	
	public static void init(Graphics g) {

		camera = new Camera(new Vector2f(0, 0), 0, 0, .07f, g);
		font = new Font(new SpriteSheet("textures/font.png"), 8);
		g.setCamera(camera);
		g.setScale(3);

		sheep = new Texture("textures/sheep.png");

		tiles = new SpriteSheet("textures/tiles.png");
		grass = new Texture(tiles.crop(new Vector2f(0, 0), new Vector2f(16, 16)));
		
		stone1 = new Texture(tiles.crop(new Vector2f(0, 0), new Vector2f(16, 16)));
		stone2 = new Texture(tiles.crop(new Vector2f(16, 0), new Vector2f(16, 16)));
		sand = new Texture(tiles.crop(new Vector2f(32, 0), new Vector2f(16, 16)));
		corner1 = new Texture(tiles.crop(new Vector2f(48, 0), new Vector2f(16, 16)));
		corner2 = new Texture(tiles.crop(new Vector2f(64, 0), new Vector2f(16, 16)));
		corner3 = new Texture(tiles.crop(new Vector2f(0, 16), new Vector2f(16, 16)));
		corner4 = new Texture(tiles.crop(new Vector2f(16, 16), new Vector2f(16, 16)));
		flat1 = new Texture(tiles.crop(new Vector2f(32, 16), new Vector2f(16, 16)));
		flat2 = new Texture(tiles.crop(new Vector2f(48, 16), new Vector2f(16, 16)));
		flat3 = new Texture(tiles.crop(new Vector2f(64, 16), new Vector2f(16, 16)));
		flat4 = new Texture(tiles.crop(new Vector2f(0, 32), new Vector2f(16, 16)));
		grass = new Texture(tiles.crop(new Vector2f(16, 32), new Vector2f(16, 16)));
		bone = new Texture(tiles.crop(new Vector2f(32, 32), new Vector2f(16, 16)));
		solid1 = new Texture(tiles.crop(new Vector2f(48, 32), new Vector2f(16, 16)));
		solid2 = new Texture(tiles.crop(new Vector2f(64, 32), new Vector2f(16, 16)));
		solid3 = new Texture(tiles.crop(new Vector2f(0, 48), new Vector2f(16, 16)));
		solid4 = new Texture(tiles.crop(new Vector2f(16, 48), new Vector2f(16, 16)));
		solid5 = new Texture(tiles.crop(new Vector2f(32, 48), new Vector2f(16, 16)));
		solid6 = new Texture(tiles.crop(new Vector2f(48, 48), new Vector2f(16, 16)));
		solid7 = new Texture(tiles.crop(new Vector2f(64, 48), new Vector2f(16, 16)));
		solid8 = new Texture(tiles.crop(new Vector2f(0, 64), new Vector2f(16, 16)));
		solid9 = new Texture(tiles.crop(new Vector2f(16, 64), new Vector2f(16, 16)));
		campfire = new Texture(tiles.crop(new Vector2f(32, 64), new Vector2f(16, 16)));

		world = new World();
		
		debug = new Texture("textures/debug.png");
		
		border = new Texture("textures/border.png");
		dark = new Texture("textures/dark.png");
		
		draglantix = new SpriteSheet("textures/draglantix.png");
		logoAnim = new Animation(3, 3, 64, 20, draglantix, 9, false);
		
		darkloop = AudioMaster.loadSound("sfx/darkloop.wav");
		
		campfireSFX = AudioMaster.loadSound("sfx/campfire.wav");
		steps1 = AudioMaster.loadSound("sfx/steps1.wav");
		steps2 = AudioMaster.loadSound("sfx/steps2.wav");
		steps3 = AudioMaster.loadSound("sfx/steps3.wav");
		
		musicSource = new Source(1.5f, 1000, 0);
		musicSource.setLooping(true);
		musicSource.setPosition(new Vector2f(0, 0));
		AudioMaster.sources.add(musicSource);
		
		title = new Texture("textures/ethuzhi.png");
		selector = new Texture("textures/selector.png");
		
		fire = new SpriteSheet("textures/fire.png");
		fireAnim = new Animation(3, 3, 32, 20, fire, 7, true);
	}
}
