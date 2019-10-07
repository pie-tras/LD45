package com.draglantix.states;

import org.joml.Vector2f;

import com.draglantix.entites.EntityManager;
import com.draglantix.entites.Player;
import com.draglantix.flare.audio.AudioMaster;
import com.draglantix.flare.audio.Source;
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
	
	private boolean wakeup = true;
	
	private float vision = 1f;
	
	private float sinIndex = 0;
	
	private Source campfire;
	
	public PlayState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
		Assets.world.init(g);
		player = new Player(Assets.sheep, new Vector2f(0, 0), new Vector2f(16, 16));
		EntityManager.dynamics.add(player);
		
		light = new FBO(Window.getWidth(), Window.getHeight());
		
		campfire = new Source(0.8f, 1, 0);
		campfire.setPosition(new Vector2f(160, 56));
		campfire.setLooping(true);
		campfire.setVolume(0.1f);
		campfire.play(Assets.campfireSFX);
		AudioMaster.sources.add(campfire);
	}

	@Override
	public void tick() {
		
		AudioMaster.setListenerData(player.getPosition());
		
		Assets.world.tick();
		updateCamera();
		float width = (WorldConfig.WORLD_SIZE.x * WorldConfig.TILE_SIZE.x * g.getScale());
		float height = (WorldConfig.WORLD_SIZE.y * WorldConfig.TILE_SIZE.y * g.getScale());
		Assets.camera.correctCamera(new Vector2f((-width/2) - ((WorldConfig.TILE_SIZE.x * g.getScale())/2), (-height/2) + ((WorldConfig.TILE_SIZE.y * g.getScale())/2)),
				new Vector2f((width - (width/2)) - ((WorldConfig.TILE_SIZE.x * g.getScale())/2), (height - (height/2)) + ((WorldConfig.TILE_SIZE.y * g.getScale())/2)));
		loopPlayer();
		
		if(wakeup) {
			vision -= 0.005f;
			if(vision < 0) {
				vision = 0;
			}
		}else {
			vision += 0.1f;
			if(vision > 1) {
				vision = 1;
				wakeup = true;
			}
		}
		
		if(sinIndex < 360) {
			sinIndex += 1;
		}else {
			sinIndex = 0;
		}
	}
	
	public void loopPlayer() {
		if(!DragonMath.isOnScreen(new Vector2f(player.getPosition()), new Vector2f(0, 0), g)) {
			wakeup = false;
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
		
		Vector2f pos = new Vector2f(480, 150);
		g.drawLight(pos, 600 + (int)(50 * Math.sin(Math.toRadians(sinIndex * 2))), new Color(255, 108, 50, 1f));
		
		light.unbindFrameBuffer();
		
		g.drawImage(Assets.fireAnim.getTexture(), new Vector2f(160, 56), new Vector2f(32, 32), new Vector2f(0, 0), new Color(255, 100, 50, 1));
		
		g.drawMode(g.DRAW_SCREEN);
		g.drawImage(light.getColorTexture(), new Vector2f(0, 0), new Vector2f(Window.getWidth()/g.getScale() + 3, -Window.getHeight()/g.getScale() - 3), new Vector2f(0, 0), new Color(255, 255, 255, 0.86f));
		//g.drawImage(Assets.border, new Vector2f(0, 0), new Vector2f(Window.getWidth()/g.getScale() + 3, Window.getHeight()/g.getScale() + 3), new Vector2f(0, 0), new Color(255, 255, 255, 0.5f));
		g.drawImage(Assets.dark, new Vector2f(0, 0), new Vector2f(Window.getWidth()/g.getScale() + 3, Window.getHeight()/g.getScale() + 3), new Vector2f(0, 0), new Color(255, 255, 255, vision));
	}

	public void updateCamera() {
		Assets.camera.move(player.getPosition());
	}

}
