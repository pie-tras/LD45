package com.draglantix.main;

import org.joml.Vector2f;

import com.draglantix.graphics.Camera;
import com.draglantix.graphics.Graphics;
import com.draglantix.textures.Font;
import com.draglantix.textures.SpriteSheet;
import com.draglantix.textures.Texture;

public class Assets {
	
	public static Camera camera;
	public static Font font;
	
	public static Texture sheep;
	
	public Assets(Graphics g) {
		
		camera = new Camera(new Vector2f(0, 0), 0, 0, .07f, g);
		font = new Font(new SpriteSheet("font.png"), 8);
		g.setCamera(camera);
		g.setScale(2);
		
		sheep = new Texture("sheep.png");
	}
}
