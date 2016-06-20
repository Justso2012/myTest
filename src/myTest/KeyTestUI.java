package myTest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class KeyTestUI extends JFrame  implements ActionListener{
	private final String setStr = "��  ��", startStr = "��  ʼ";
	private final String endStr = "��  ��", versionStr = "��  ��";
	private JPanel jp1,jp2,jp3;
	private JToolBar tools;
	private Button setBtn, startBtn, endBtn,versionBtn;
	private JLabel actionDescLab,actionLab,inputDescLab;
	private JTextField inputText;
	
	public KeyTestUI(){
		InitMainInterface();
		Rectangular rect = new Rectangular();
		this.add(rect);
		this.addKeyListener(rect);
		rect.setFocusable(true);
	//	this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		KeyTestInput mainJp = new KeyTestInput();

		this.add(mainJp);
		this.addKeyListener(mainJp);
		mainJp.requestFocus();		


		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		Thread t = new Thread(mainJp);
		t.start();
		
	}
	
	public void InitMainInterface(){
		this.setTitle("ģ�ⰴ������");
		this.setLayout(new BorderLayout());
		this.setBounds(200, 100, 400, 300);

		
		tools = new JToolBar();
		setBtn = new Button(setStr);
		setBtn.addActionListener(this);
		tools.add(setBtn);
		
		
		startBtn = new Button(startStr);
		startBtn.addActionListener(this);
		tools.add(startBtn);
		
		endBtn = new Button(endStr);
		endBtn.addActionListener(this);
		tools.add(endBtn);

		versionBtn = new Button(versionStr);	
		versionBtn.addActionListener(this);
		tools.add(versionBtn);

		this.add(tools, BorderLayout.NORTH);	
/*		
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2,2,5,5));
		actionDescLab = new JLabel("����ֵ:", JLabel.CENTER);
		actionDescLab.setFont(new Font("", Font.ROMAN_BASELINE, 14));
		jp1.add(actionDescLab);
		
		actionLab = new JLabel("");
		jp1.add(actionLab);
		
		inputDescLab = new JLabel("���밴��:", JLabel.CENTER);
		inputDescLab.setFont(new Font("", Font.ROMAN_BASELINE, 14));
		jp1.add(inputDescLab);
		
		inputText = new JTextField();
		jp1.add(inputText);
		this.add(jp1, BorderLayout.CENTER);
		

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
*/		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button btn = (Button)e.getSource();
		String str = btn.getLabel();
		System.out.println("str="+str);
		/*switch(str){
		case setStr:
			new SetKeyValue();
			break;
		case startStr:
			break;
		case endStr:
			break;
		case versionStr:
			new ShowVersion();
			break;
		default:
			break;
		}*/
		
	}
}
