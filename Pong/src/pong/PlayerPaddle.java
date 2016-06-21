package pong;

import java.awt.Color;
import java.awt.Graphics;

public class PlayerPaddle {
	int x;
	int y;
	int width = 15;
	int height= 40;
	
	boolean goup = false;
	boolean godown = false;
	
	
	public PlayerPaddle(int x, int y){
		this.x = x;
		this.y = y;
		
	}

	public void tick(Pong p){
		if(goup && y  >= 0){
			y--;
		}
		if(godown && y <= p.getHeight() - height){
			y++;
		}
	}
	
	public void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}
}
