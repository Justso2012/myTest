package myTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZiMu extends JFrame {
	ZiMu() {
		this.setSize(300, 600);
		this.setResizable(false);
		this.setTitle("������Ϸ");
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
			x[i] = (int) (Math.random() * 300); // �������λ�õĺ�����
			y[i] = (int) (Math.random() * 300); // �������λ�õ�������
			z[i] = new String("" + (char) (Math.random() * 25 + 65)); 
			// 0 ~ 25��ʾ26����ĸ,��65��ʾΪascii�� A ~ Z
			System.out.println("Hello ��"+ i +"��y="+y[i]+"��"+z[i]);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		this.setBackground(Color.black);
		g.setColor(Color.WHITE);
		g.drawString("һ������ȷ��Ե���ĸ�� " + sum, 10, 560);
		for (int i = 0; i < 3; i++) {
			g.drawString(z[i], x[i], y[i]);
		}
	}

	@Override
	public void run() {
		long g = System.currentTimeMillis();

		while (System.currentTimeMillis() - g <= 600000) {

			for (int i = 0; i < 3; i++) {
				System.out.println("��"+ i +"��y="+y[i]);
				y[i]+=10;
				if (y[i] >= 600) {
					sum -= 1;
					y[i] = (int) (Math.random() * 50);
					x[i] = (int) (Math.random() * 280);
					z[i] = new String("" + (char) (Math.random() * 25 + 65));
					System.out.println("World ��"+ i +"��y="+y[i]+"��"+z[i]);
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
				if (0 < y[i]) {			//�ж��ַ��Ƿ��Ѿ����������ʾ
					j = i;
				}
			}
		}
		if (j != -1) {
			z[j] = new String("" + (char) (Math.random() * 25 + 65));
			y[j] = 0;
			System.out.println("Deala ��"+ j +"��y="+y[j]+"��"+z[j]);

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