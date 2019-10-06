package com.draglantix.states;

import org.joml.Vector2f;

import com.draglantix.entites.EntityManager;
import com.draglantix.entites.Player;
import com.draglantix.entites.Sheep;
import com.draglantix.flare.graphics.Graphics;
import com.draglantix.flare.util.Functions;
import com.draglantix.main.Assets;

public class PlayState extends GameState {

	public static Player player;
	
	public PlayState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
		Assets.world.init(g);
		player = new Player(Assets.sheep, new Vector2f(0, 0), new Vector2f(16, 16));
		EntityManager.dynamics.add(player);
		
		for(int i = 0; i < 100; i++) {
			EntityManager.dynamics.add(new Sheep(Assets.sheep, new Vector2f(Functions.rand.nextInt(100), Functions.rand.nextInt(100)), new Vector2f(16, 16)));
		}
	}

	@Override
	public void tick() {
		Assets.world.tick();
		updateCamera();
	}

	@Override
	public void render() {
		g.drawMode(g.DRAW_WORLD);
		Assets.world.render(g);
	}

	public void updateCamera() {
		Assets.camera.move(player.getPosition());
	}

}
