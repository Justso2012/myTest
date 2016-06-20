package myTest;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ShowVersion extends JDialog{
	private static final long serialVersionUID = 1L; 
	
	public ShowVersion(){
		this.setTitle("版  本");
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		JLabel verLabel = new JLabel("当前版本:Version "+ serialVersionUID, SwingConstants.CENTER );
		JLabel descLabel = new JLabel("版权所有,谁要谁拿走", SwingConstants.CENTER);
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(2,1));
		
		jp.add(verLabel);
		jp.add(descLabel);
		container.add(jp);
	//	this.add(dialog);
		this.setBounds(250, 150,300, 150);	
		this.setVisible(true);
	}

}
