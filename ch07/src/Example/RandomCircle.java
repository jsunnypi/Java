package Example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyPanel extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawOval(10, 10, 50, 50);
	}
	
	public MyPanel() {
		setLayout(null);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				CircleThread ct = new CircleThread(0, 0);
				ct.start();
			}
		});
	}

	class CircleThread extends Thread {
		private JLabel circle;

		public CircleThread(int circleX, int circleY) {
			circle = new JLabel();
			circle.setLocation(circleX, circleY);
			add(circle);
			MyPanel.this.repaint();
		}

		public void run() {
			while (true) {
				int x = circle.getX();
				int y = circle.getY();

				circle.setLocation(x, y);
				MyPanel.this.repaint();
				
				try {
					sleep(500);
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}
}

public class RandomCircle extends JFrame {
	public RandomCircle() {
		setTitle("원 랜덤 이동");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		MyPanel m = new MyPanel();
		setContentPane(m);
		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RandomCircle();
	}

}
