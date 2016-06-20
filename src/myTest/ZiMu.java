package myTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZiMu extends JFrame {
	ZiMu() {
		this.setSize(300, 600);
		this.setResizable(false);
		this.setTitle("打字游戏");
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyPanel mp = new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);

		Thread t = new Thread(mp);
		t.start();
	}

	public static void main(String args[]) {
		ZiMu w = new ZiMu();
		w.setVisible(true);

	}

}

class MyPanel extends JPanel implements Runnable, KeyListener {
	int x[] = new int[3];
	int y[] = new int[3];
	int sum = 0;
	String z[] = new String[3];

	MyPanel() {

		for (int i = 0; i < 3; i++) {
			x[i] = (int) (Math.random() * 300); // 随机出现位置的横坐标
			y[i] = (int) (Math.random() * 300); // 随机出现位置的纵坐标
			z[i] = new String("" + (char) (Math.random() * 25 + 65)); 
			// 0 ~ 25表示26个字母,加65表示为ascii码 A ~ Z
			System.out.println("Hello 第"+ i +"个y="+y[i]+"是"+z[i]);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		this.setBackground(Color.black);
		g.setColor(Color.WHITE);
		g.drawString("一分钟正确打对的字母： " + sum, 10, 560);
		for (int i = 0; i < 3; i++) {
			g.drawString(z[i], x[i], y[i]);
		}
	}

	@Override
	public void run() {
		long g = System.currentTimeMillis();

		while (System.currentTimeMillis() - g <= 600000) {

			for (int i = 0; i < 3; i++) {
				System.out.println("第"+ i +"个y="+y[i]);
				y[i]+=10;
				if (y[i] >= 600) {
					sum -= 1;
					y[i] = (int) (Math.random() * 50);
					x[i] = (int) (Math.random() * 280);
					z[i] = new String("" + (char) (Math.random() * 25 + 65));
					System.out.println("World 第"+ i +"个y="+y[i]+"是"+z[i]);
				}
			}
			try {
				Thread.sleep(200);
			} catch (Exception e) {
			}
			this.repaint();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO: Add your code here
	}

	@Override
	public void keyPressed(KeyEvent e) {
		String keychar = new String("" + e.getKeyChar());
		int j = -1;

		for (int i = 0; i < 3; i++) {
			if (keychar.equals(z[i])) {
				if (0 < y[i]) {			//判断字符是否已经在面板上显示
					j = i;
				}
			}
		}
		if (j != -1) {
			z[j] = new String("" + (char) (Math.random() * 25 + 65));
			y[j] = 0;
			System.out.println("Deala 第"+ j +"个y="+y[j]+"是"+z[j]);

			sum += 1;

		} else {
			sum -= 1;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO: Add your code here
	}
}