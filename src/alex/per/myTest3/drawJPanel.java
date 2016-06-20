package alex.per.myTest3;

import java.awt.Graphics;

import javax.swing.JPanel;

public class drawJPanel extends JPanel implements Runnable{

	private int width=10, height=10;
	private int x =150,y=150;
	private int num;
	
	public drawJPanel(int num){
		this.num = num;
	}


	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, width, height);
		//System.out.println("hwllo");
	//	g.drawString("Hello World", 200,  500);
	}

	public void repaint(){
		super.repaint();
		x +=num;
		y +=num;
	}

	@Override
	public void run() {

		while(true){
			try {
				//System.out.println("kkkkkk");
				/*x+=num;
				y+=num;*/
				repaint();
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		// TODO Auto-generated method stub
		
	}
}
