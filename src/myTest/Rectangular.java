package myTest;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Rectangular extends JPanel implements KeyListener{
	
	 public Rectangular() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.blue);
	}	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String charStr = new String(""+e.getKeyChar());
		System.out.println(charStr);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
