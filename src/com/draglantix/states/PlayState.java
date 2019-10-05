package com.draglantix.states;

import com.draglantix.flare.graphics.Graphics;
import com.draglantix.main.Assets;

public class PlayState extends GameState {

	public PlayState(Graphics g, GameStateManager gsm) {
		super(g, gsm);
		Assets.world.init();
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
		Assets.camera.move(Assets.player.getPosition());
	}

}
