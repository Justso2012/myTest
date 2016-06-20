package alex.per.myTest2;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class testKeyListener extends JFrame{
	
	public testKeyListener(){
		super();
		Button btn = new Button("Hello");
		add(btn);
		setLocation(100, 100);
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int num = e.getKeyCode();
				// TODO Auto-generated method stub
				switch(num){
				case 37:
					System.out.println("heihei");
					break;
				default:
					System.out.println(num+"hello world");
					break;
				}
			}
		});
	}
	
	public testKeyListener(String name){
		super(name);
		Button btn = new Button("Hello");
		add(btn);
		setLocation(100, 100);
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn.addActionListener(new action());
		
		
	}
	
	class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("i just try");
		}
		
	}
	
	public static void main(String[] args){
//		testKeyListener test = new testKeyListener();
		testKeyListener test = new testKeyListener("window");
	}
}
