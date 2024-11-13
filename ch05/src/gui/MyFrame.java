package gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		setTitle("처음 만드는 GUI 프로그램");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}
