package gui;

import java.awt.*;

import javax.swing.*;


public class Sample1 extends JFrame{
	private Mypanel panel = new Mypanel();
	
	public Sample1(){
		setTitle("그래픽");
		setSize(250,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setContentPane(panel);
	}
	class Mypanel extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.drawRect(10, 10, 50, 50);
			
		}
	}
	
	public static void main(String[] args) {
		new Sample1();
	}

}
