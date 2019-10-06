package com.draglantix.states;

import org.joml.Vector2f;

import com.draglantix.entites.EntityManager;
import com.draglantix.entites.Player;
import com.draglantix.flare.graphics.Graphics;
import com.draglantix.flare.util.Color;
import com.draglantix.flare.util.FBO;
import com.draglantix.flare.window.Window;
import com.draglantix.main.Assets;
import com.draglantix.utils.DragonMath;
import com.draglantix.world.WorldConfig;

public class PlayState extends GameState {

	public static Player player;
	
	private FBO light;
	
	public PlayState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
		Assets.world.init(g);
		player = new Player(Assets.sheep, new Vector2f(0, 0), new Vector2f(16, 16));
		EntityManager.dynamics.add(player);
		
		light = new FBO(Window.getWidth(), Window.getHeight());
	}

	@Override
	public void tick() {
		Assets.world.tick();
		updateCamera();
		float width = (WorldConfig.WORLD_SIZE.x * WorldConfig.TILE_SIZE.x * g.getScale());
		float height = (WorldConfig.WORLD_SIZE.y * WorldConfig.TILE_SIZE.y * g.getScale());
		Assets.camera.correctCamera(new Vector2f((-width/2) - ((WorldConfig.TILE_SIZE.x * g.getScale())/2), (-height/2) - ((WorldConfig.TILE_SIZE.x * g.getScale())/2)),
				new Vector2f((width - (width/2)) - ((WorldConfig.TILE_SIZE.x * g.getScale())/2), (height - (height/2)) - ((WorldConfig.TILE_SIZE.x * g.getScale())/2)));
		loopPlayer();
	}
	
	public void loopPlayer() {
		if(!DragonMath.isOnScreen(new Vector2f(player.getPosition()), new Vector2f(0, 0), g)) {
			Vector2f min = new Vector2f(-(WorldConfig.WORLD_SIZE.x * WorldConfig.TILE_SIZE.x / 2), 
					-(WorldConfig.WORLD_SIZE.y * WorldConfig.TILE_SIZE.y / 2));
			Vector2f max = new Vector2f((WorldConfig.WORLD_SIZE.x * WorldConfig.TILE_SIZE.x / 2),
					(WorldConfig.WORLD_SIZE.y * WorldConfig.TILE_SIZE.y / 2));
		
			Vector2f pos = new Vector2f(0, 0);
			
			if(player.getPosition().x < min.x) {
				pos = new Vector2f(max.x - 5, player.getPosition().y);
				correctPos(pos);
			}else if(player.getPosition().x > max.x) {
				pos = new Vector2f(min.x + 5, player.getPosition().y);
				correctPos(pos);
			}
			
			if(player.getPosition().y < min.y) {
				pos = new Vector2f(player.getPosition().x, max.y - 5);
				correctPos(pos);
			}else if(player.getPosition().y > max.y) {
				pos = new Vector2f(player.getPosition().x, min.y + 5);
				correctPos(pos);
			}
			
		}
		
	}

	private void correctPos(Vector2f pos) {
		player.setPosition(pos);
		player.getBounds().setPosition(pos);
		Assets.camera.setPosition(new Vector2f(pos));
	}
	
	@Override
	public void render() {
		g.drawMode(g.DRAW_WORLD);
		Assets.world.render(g);
		
		light.bindFrameBuffer();
		g.clearColor(new Color(0, 0, 0, 0));
		
		Vector2f pos = new Vector2f(0, 0);
		g.drawLight(pos, 105, new Color(255, 255, 255, 1f));
		
		light.unbindFrameBuffer();

		g.drawMode(g.DRAW_SCREEN);
		
		//System.out.println(Assets.camera.getPosition());
		
		g.drawImage(light.getColorTexture(), new Vector2f(0, 0), new Vector2f(Window.getWidth()/2, Window.getHeight()/2), new Vector2f(0, 0), new Color(255, 255, 255, 0.5f));
		g.drawImage(Assets.border, new Vector2f(0, 0), new Vector2f(Window.getWidth(), Window.getHeight()), new Vector2f(0, 0), new Color(255, 255, 255, 1));
	}

	public void updateCamera() {
		Assets.camera.move(player.getPosition());
	}

}
