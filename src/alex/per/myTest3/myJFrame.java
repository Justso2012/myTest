package alex.per.myTest3;

import javax.swing.JFrame;

public class myJFrame extends JFrame{
	private String title;
	private int width, height;

	public myJFrame(){
		
	}


	
	public void launch(){
		setLocation(100, 100);
		setSize(800, 600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawJPanel jp1 = new drawJPanel(5);
		add(jp1);
		

		Thread t  = new Thread(jp1);
		t.start();

		setVisible(true);
		
		//jp1.init();
		
	}
	

	public static void main(String args[]){
		myJFrame jf = new myJFrame();
		jf.launch();

		 
	}


}

