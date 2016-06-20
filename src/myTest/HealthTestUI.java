package myTest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class HealthTestUI /*extends JFrame*/ {
	JFrame frame;
	JLabel laTitle;
	JLabel laName,laHeight,laWeight;
	JTextField jtName, jtHeight, jtWeight;
	JLabel laResult, laShowResult;
	JButton btnReset, btnRecord;
	JPanel Jp1,Jp2,Jp3;
	
	public HealthTestUI(){
		Init();
	}
	
	public void Init(){
	//	this.setName("BMI指数计算");
		frame = new JFrame("HEllo");
		Container conter = frame.getContentPane();
		
		GridBagLayout mainlayout = new GridBagLayout();
//		BorderLayout borderlayout = new BorderLayout();
//		this.setLayout(mainlayout);	
		conter.setLayout(mainlayout);
		GridBagConstraints gridconst = new GridBagConstraints();
		gridconst.fill = GridBagConstraints.NONE;

		
//		GridLayout gridlayout = new GridLayout();	
//		FlowLayout flowlayout1 = new FlowLayout(FlowLayout.CENTER, 10, 20);
		laTitle = new JLabel("请输入你的身高、体重");
		laTitle.setFont(new Font("", Font.ROMAN_BASELINE,20));
		gridconst.gridx = 0;
		gridconst.gridy = 0;
		gridconst.gridwidth = 0;
		gridconst.weightx = 0;
		gridconst.weighty = 0;
		mainlayout.setConstraints(laTitle, gridconst);
		conter.add(laTitle);
		
		

//		FlowLayout flowlayout2 = new FlowLayout(FlowLayout.LEFT);
		laName = new JLabel("姓  名:");
		laName.setBackground(Color.RED);
	//	laName.setFont(new Font("", Font.ROMAN_BASELINE,15));
		gridconst.gridx = 0;
		gridconst.gridy = 1;
		gridconst.gridwidth = 1;
		gridconst.weightx = 1;
		gridconst.weighty = 0;
//	gridconst.fill = GridBagConstraints.BOTH;
		mainlayout.setConstraints(laName, gridconst);
		conter.add(laName);
/*				
		jtName = new JTextField();
		gridconst.gridx = 1;
		gridconst.gridy = 1;
		gridconst.gridwidth = 1;
		gridconst.weightx = 50;
		gridconst.fill = GridBagConstraints.BOTH;
		mainlayout.setConstraints(jtName, gridconst);
		conter.add(jtName);	
*/		
		
		laHeight = new JLabel("身高(cm):");
		laHeight.setBackground(Color.GREEN);
		laHeight.setFont(new Font("", Font.ROMAN_BASELINE,15));
		gridconst.gridx = 1;
		gridconst.gridy = 1;
		gridconst.gridwidth = 1;
		gridconst.weightx = 5;
//		gridconst.fill = GridBagConstraints.BOTH;
		mainlayout.setConstraints(laHeight, gridconst);
		conter.add(laHeight);
		/*		
		jtHeight = new JTextField();
		gridconst.gridx = 1;
		gridconst.gridy = 2;

		gridconst.gridwidth = 2;
		mainlayout.setConstraints(jtHeight, gridconst);
		conter.add(jtHeight);	
		
					
		laWeight = new JLabel("体重(kg):");
		laWeight.setFont(new Font("", Font.ROMAN_BASELINE,15));
	//	gridconst.gridx = 0;
	//	gridconst.gridy = 3;
		gridconst.gridwidth = 1;

		mainlayout.setConstraints(laWeight, gridconst);
		conter.add(laWeight);
			
		jtWeight = new JTextField();
	//	gridconst.gridx = 1;
	//	gridconst.gridy = 3;
		gridconst.gridwidth = 2;
		mainlayout.setConstraints(jtWeight, gridconst);
		conter.add(jtWeight);
		
		
		laResult = new JLabel("结果：");
		laResult.setFont(new Font("", Font.ROMAN_BASELINE,15));
		gridconst.gridx = 5;
		gridconst.gridy = 2;
		gridconst.gridwidth = 2;
		mainlayout.setConstraints(laResult, gridconst);
		conter.add(laResult);	
		
		laShowResult = new JLabel();
		laShowResult.setFont(new Font("", Font.ROMAN_BASELINE,15));
	//	gridconst.gridx = 4;
	//	gridconst.gridy = 1;
		gridconst.gridwidth = 1;
		mainlayout.setConstraints(laShowResult, gridconst);
		conter.add(laShowResult);			
/*		
		mainlayout.setConstraints(laName, gridconst);
		conter.add(laName);		
		laHeight = new JLabel("身高:");	
		laHeight.setFont(new Font("", Font.ROMAN_BASELINE,15));
		jtHeight = new JTextField();
		
		laWeight = new JLabel("体重:");	
		laWeight.setFont(new Font("", Font.ROMAN_BASELINE,15));
		jtWeight = new JTextField();

		conter.add(Jp2, BorderLayout.WEST);	
/*		
		laTitle.setHorizontalAlignment(SwingConstants.LEADING);
		
		laHeight = new JLabel("身高:");
		laHeight.setHorizontalAlignment(SwingConstants.LEFT);
		
		laWeight = new JLabel("体重:");
		laWeight.setHorizontalAlignment(SwingConstants.LEFT);	
*/			
//		conter.add(frame)
		frame.pack();
		frame.setVisible(true);
	 	frame.setSize(400,300);
	//	frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);/*
		conter.add(laTitle);
		conter.add(laHeight);
		conter.add(laWeight);

	*/	
	}
	
	
	private double height;
	private double weight;
	
	public HealthTestUI(double height, double weight){
		this.height = height;
		this.weight = weight;
	}
	
	public void CalculateBMI(){
		double Result = 0;
		
		Result = weight / ( height * height);
		
		if(Result < 18.5)
			System.out.println ("过轻");
		else if(Result >= 18.5 && Result <= 24.99)
			System.out.println ("正常");
		else if(Result >=25 && Result <=28)
			System.out.println ("过重");
		else if(Result >28 && Result <= 32)
			System.out.println ("肥胖");
		else if(Result >32)
			System.out.println ("特大胖子");	
	}
}
