package com.draglantix.entites;

import java.util.ArrayList;
import java.util.List;

import com.draglantix.flare.graphics.Graphics;

public class EntityManager {

	public static List<Dynamic> dynamics = new ArrayList<Dynamic>();	
	public static List<Dynamic> deadDynamics = new ArrayList<Dynamic>();
	
	public static void tick() {
		for(Dynamic d: dynamics) {
			d.tick();
			if(!d.alive) {
				deadDynamics.add(d);
			}
		}
		dynamics.removeAll(deadDynamics);
		deadDynamics.removeAll(deadDynamics);
	}
	
	public static void render(Graphics g) {
		for(Dynamic d: dynamics) {
			d.render(g);
		}
	}
	
}
