package myTest;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeyTestInput  extends JPanel implements Runnable,KeyListener{
	private final String startStr = "开  始", endStr = "结  束";
	private JPanel JpBtn, JpShow,JpTest;
	private Button startBtn,endBtn;
	private JLabel hintLabel,showKeyLabel, showResultLabel;
	private JTextField inputText;
	private String keyList[] = {"A", "B", "C", "D","E"};
	
	public KeyTestInput() {
		this.setLayout(new GridLayout(1,1));
		this.setBackground(Color.green);
		
		JpBtn = new JPanel();
		JpBtn.setLayout(new FlowLayout());
		startBtn = new Button(startStr);
		endBtn =new Button(endStr);
		JpBtn.add(startBtn);
		JpBtn.add(endBtn);
		this.add(JpBtn);
	
		JpShow = new JPanel();
		hintLabel = new JLabel("传球给:");
		JpShow.add(hintLabel);
		showKeyLabel = new JLabel();
		JpShow.add(showKeyLabel);

		
		JpTest = new JPanel();
		JpTest.addKeyListener(this);
		showResultLabel = new JLabel("");
		inputText = new JTextField("");
		showResultLabel.setFont(new Font("", Font.ROMAN_BASELINE, 15));
		JpShow.add(showResultLabel);
		this.add(JpTest);
		this.add(JpShow);	
	//	this.addKeyListener(JpShow);
		
	}
	public void getRandomKey(){
		String keyStr = null;
		Random random = new Random();
		int num = -1;
		
		num = random.nextInt(5);
		keyStr = new String(keyList[num]);
		showKeyLabel.setText("传球给"+keyStr);

		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count = 5;
		while(count > 0){
			getRandomKey();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count--;
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("here");
		// TODO Auto-generated method stub
		String keychar = new String("" + e.getKeyChar());
		String keyStr = showKeyLabel.getText();
		if(keychar.equals(keyStr)){
			showResultLabel.setText("神助攻");
		}else{
			showResultLabel.setText("猪队友");
		}
		System.out.println("输入"+ keychar);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
