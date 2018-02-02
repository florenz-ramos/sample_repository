package com.testgame;

import javax.swing.JFrame;

public class Drivers {

	public static void main(String[] args) {
		GameEngine game=new GameEngine();
		game.frame.setTitle("My Game");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setVisible(true);
		game.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		game.Start();
	}

}
