package per.alex.testUI;

public class MainUI {
	public static void main(String args[]){
		MyFrame mf = new MyFrame();
		
		mf.setLayout(null);
		GamePanel gp = new GamePanel();
		mf.add(gp);
		
		ControlPanel cp = new ControlPanel();
		mf.add(cp);
		
		mf.setVisible(true);
	}

}
