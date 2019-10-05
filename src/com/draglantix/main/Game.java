package com.draglantix.main;

import com.draglantix.flare.main.FlareEngine;
import com.draglantix.states.GameStateManager;
import com.draglantix.main.Settings;

public class Game {

	public static void main(String[] args) {
		new FlareEngine(new GameStateManager(), Settings.FPS_CAP, Settings.WINDOW_WIDTH, Settings.WINDOW_HEIGHT,
				Settings.WINDOW_TITLE, Settings.DEBUG);
	}

}
