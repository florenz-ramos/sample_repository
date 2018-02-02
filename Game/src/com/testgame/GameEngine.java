package com.testgame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameEngine extends JPanel implements Runnable {
	public GameEngine() {
		this.setPreferredSize(new Dimension(width,height));
		frame=new JFrame();
		keys=Keyboard.getInstance();
		frame.addKeyListener(keys);
	}
	private int width=400;
	private int height=350;
	private int posX=width/2;
	private int posY=height/2;
	private int fPosX=100;
	private int fPosY=50;
	public static int lives=3;
	public int score=0;
	public Keyboard keys;
	
	Random r=new Random();
	public JFrame frame;
	Thread thread;
	
	public boolean isRunning;
	@Override
	public void run() {
		try {
			while(isRunning) {
				updateGame();
				thread.sleep(20);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void Start() {
		isRunning=true;
		thread=new Thread(this,"");
		thread.start();
		
	}
	public void Stop() {
		isRunning=false;
		try {
			thread.join();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void updateGame() {
		repaint();
	}
	public void Movement() {
		if(keys.isDown(KeyEvent.VK_A)) {
			posX-=1;
		
		}
		if(keys.isDown(KeyEvent.VK_D)) {
			posX+=1;
		}
		if(keys.isDown(KeyEvent.VK_W)) {
			posY-=1;

		}
		if(keys.isDown(KeyEvent.VK_S)) {
			posY+=1;
		}
	}
	public void foodPosition() {
		fPosX=r.nextInt(380); //10
		fPosY=r.nextInt(300); //10
		if((fPosX>364|| fPosX<15)||(fPosY>315||fPosY<=53)) {
			fPosX=r.nextInt(380); //10 <40
			fPosY=r.nextInt(300); //<10
		}
	}
	public void Cheat() {
		if(keys.isDown(KeyEvent.VK_C)) {
			lives=99;
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Lives:"+lives,20,30);
		g.drawString("Score:"+score,70,30);
		g.drawRect(10,40,380,300);
		g.setColor(Color.GREEN);
		g.fillRect(10,40,380,300);		
		g.setColor(Color.RED);
		g.fillRect(fPosX,fPosY,25,25);
		g.setColor(Color.BLUE);
		g.fillRect(posX,posY,25,25);
		Movement();
		Cheat();
		if(posX==fPosX && posY==fPosY) {
			score+=100;
			foodPosition();
		}
		if((posX>364||posX<12)||(posY>315||posY<=43)) {
			lives+=-1;
			posX=400/2;
			posY=350/2;
			foodPosition();
		}
		if(lives==0) {
			super.paintComponent(g);
			g.drawString("GAME OVER:",(380/2)-20,300/2);
			g.drawString("SCORES:"+score, (380/2)-20,(300/2)+20);
			g.drawString("PRESS R TO CONTINUE",(380/2)-20,(300/2)+40);
			if(keys.isDown(KeyEvent.VK_R)) {
				super.paintComponent(g);
				g.drawRect(10,40,380,300);
				g.drawString("Lives:"+lives,20,30);
				g.drawString("Score:"+score,70,30);
				g.setColor(Color.GREEN);
				g.fillRect(fPosX,fPosY,25,25);
				g.setColor(Color.BLUE);
				g.fillRect(posX,posY,25,25);
				foodPosition();
				lives=3;
				score=0;
				posX=400/2;
				posY=350/2;
			}
		}
	}
}
