package per.alex.testUI;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	
	private final JButton btnStart; 
	
	public ControlPanel(){
		setBounds(405, 0, 200, 500);
		setBackground(Color.black);
		
		setLayout(null);
		btnStart = new JButton();
		
		btnStart.setBounds(0, 0, 100, 50);
		btnStart.setText("Start");
		add(btnStart);
		
	}
}
