package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseDragEx2 extends JFrame{
	
	public MouseDragEx2() {
		setTitle("마우스 이미지 드래그 실습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setContentPane(new MyPanel());
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/apple.jpg");
		private Image img = icon.getImage();
				
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionAdapter() {
				@Override
				public void mouseDragged(MouseEvent e) {
					
					repaint();
				}
			});
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			
		}
	}
	
	
	
	public static void main(String[] args) {
		new MouseDragEx2();
	}

}
