package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseDragEx extends JFrame{
	
	public MouseDragEx() {
		setTitle("마우스 이미지 드래그 연습"); // == super("마우스 이미지 드래그 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setContentPane(new MyPanel());		
		setVisible(true);		
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/back.jpg");
		private Image img = icon.getImage();
		private int ovalX = 100, ovalY = 100; // 원의 중심 좌표
		private final int RADIUS = 20; // 원의 반지름
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					ovalX = e.getX();
					ovalY = e.getY();
					repaint();
				}
				
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			g.setColor(Color.green);
			g.fillOval(ovalX, ovalY, RADIUS, RADIUS);
		}
		
		
	}

	public static void main(String[] args) {
		new MouseDragEx();
	}

}
