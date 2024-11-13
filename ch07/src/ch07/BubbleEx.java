package ch07;

import java.awt.event.*;

import javax.swing.*;


class GamePanel extends JPanel{
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				BubbleThread bt = new BubbleThread(e.getX(), e.getY());
				bt.start();
			}
		});
	}
	
	class BubbleThread extends Thread{
		private JLabel bubble;
		
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon("bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(), img.getIconHeight());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble);
			GamePanel.this.repaint();
		}
		
		@Override
		public void run() {
			while(true) {
				int x = bubble.getX();
				int y = bubble.getY()-5;
				
				if(y<0) {
					GamePanel.this.remove(bubble);
					GamePanel.this.repaint();
					return;
				}
				bubble.setLocation(x, y);
				GamePanel.this.repaint();
				try {
					sleep(200);
				}
				catch(InterruptedException e) {
					return;
				}
			}
		}
	}
}


public class BubbleEx extends JFrame{

	public BubbleEx() {
		setTitle("Bubble Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BubbleEx();
	}

}
