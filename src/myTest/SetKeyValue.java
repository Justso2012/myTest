package myTest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SetKeyValue extends JFrame {

	private String IconList[] = {"A","B","D","C","LF2","RF2","LF1","RF1"};
	private String ActionList[] = {"Pass", "Fake Pass", "Post Up", "Shoot",
			"Positional Plays/Pick Control", "Icon Pass", "Clutch","Sprint"};
	private String DefaultKeyList[] = {"X","C","S","D","TAB","A","SPACE","LEFT SHIFT"};
	private JTextField KeyValueList[] = new JTextField[DefaultKeyList.length];
	private Button setDefaultBtn, recordBtn;
	
	public SetKeyValue(){
		int rows = 0,columns = 3;
		this.setName("按键设置");
		this.setBounds(300, 150, 400, 500);
		rows = ActionList.length+2;
		this.setLayout(new GridLayout(rows, columns, 15,10));
		this.setBackground(Color.BLUE);
		add(new JLabel("ICON", SwingConstants.CENTER)).setFont(new Font("", Font.BOLD, 15));
		add(new JLabel("ACTION", SwingConstants.CENTER)).setFont(new Font("", Font.BOLD, 15));
		add(new JLabel("BUTTON", SwingConstants.CENTER)).setFont(new Font("", Font.BOLD, 15));
		for(int i = 0;i < IconList.length;i++){
			add(new JLabel(IconList[i], SwingConstants.CENTER));
			add(new JLabel(ActionList[i], SwingConstants.CENTER));
			KeyValueList[i] = new JTextField(DefaultKeyList[i]);
			KeyValueList[i].setHorizontalAlignment(SwingConstants.CENTER);
			add(KeyValueList[i]);
		}
		
		setDefaultBtn = new Button("重置默认值");
		setDefaultBtn.setFont(new Font("", Font.ROMAN_BASELINE, 15));
		setDefaultBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = 0;i < KeyValueList.length;i ++){
					KeyValueList[i].setText(DefaultKeyList[i]);
				}
				
			}
		});
		add(setDefaultBtn);
		add(new JLabel(""));
		
		recordBtn = new Button("记    录");
		recordBtn.setFont(new Font("", Font.ROMAN_BASELINE, 15));
		recordBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(recordBtn);
		this.setVisible(true);
	}
	
}
