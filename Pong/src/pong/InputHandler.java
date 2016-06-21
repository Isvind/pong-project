package pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputHandler implements KeyListener {
	
	public InputHandler(Pong p){
		p.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
	int code = e.getKeyCode();
		
		if (code == e.VK_W){
			Pong.player.goup = true;
			Pong.player.godown = false;
		}
		if (code == e.VK_S){
			Pong.player.godown = true;
			Pong.player.goup = false;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
