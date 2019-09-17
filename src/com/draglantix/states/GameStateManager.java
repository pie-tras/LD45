package com.draglantix.states;

import com.draglantix.main.Assets;
import com.draglantix.main.GSM;
import com.draglantix.main.Settings;

public class GameStateManager extends GSM{
	
	private static GameState currentState;
	
	private static SplashState splashState;
	private static IntroState introState;
	private static MenuState menuState; 
	private static PlayState playState; 
	
	@Override
	public void init() {
		super.init();
		new Assets(g);
		splashState = new SplashState(g);
		introState = new IntroState(g);
		menuState = new MenuState(g);
		playState = new PlayState(g);
		setState(Settings.START_STATE);
	}

	@Override
	public void update() {
		super.update();
		currentState.tick();
		currentState.render();
	}
	
	public static void setState(States state) {
		if(currentState!=null)
			currentState.stop();
		switch(state) {
		
			case SPLASH:
			currentState = splashState;
			break;
			
			case INTRO:
			currentState = introState;
			break;
			
			case MENU:
			currentState = menuState;
			break;
			
			case PLAY:
			currentState = playState;
			break;
			
			default:
			break;
		
		}
		currentState.start();
	}
	
}