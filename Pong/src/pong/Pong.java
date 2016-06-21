package pong;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JFrame.*;

public class Pong extends Canvas implements Runnable{
	
	JFrame f;
	InputHandler IH;
	
	public final int WIDTH = 400; //width / height of the game
	public final int HEIGHT = WIDTH / 16 * 9;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);//dimension is basically for saving the dimension of something
	public final String title = "Pong indev";
	boolean gameRunning = false; // Wether the game is running
	public static PlayerPaddle player;
	

	
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	
	
	public void run() {
		
		while(gameRunning) {
			tick();
			render();
			
			try{
				Thread.sleep(7);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public synchronized void start(){
		gameRunning = true;
		new Thread(this).start();
	}
	
	public synchronized void stop(){
		gameRunning = false;
		System.exit(0);
		
	}
	
	public Pong(){
	f = new JFrame();
	setMinimumSize(gameSize);
	setPreferredSize(gameSize);
	setMaximumSize(gameSize);
	
	f.add(this, BorderLayout.CENTER);
	f.pack();
	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	f.setResizable(false);
	f.setTitle(title);
	f.setLocationRelativeTo(null);

	IH = new InputHandler(this);
	player = new PlayerPaddle(10, 40);
	

	}
	
	public void tick() {
		player.tick(this);
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
			}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		player.render(g);
		
		g.dispose();
		bs.show();
		}
	
	public static void main(String[] args){
		Pong p = new Pong();
		p.start();
		
		
		
	}

}
