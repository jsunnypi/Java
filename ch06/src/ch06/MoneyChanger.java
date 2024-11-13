package ch06;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MoneyChanger extends JFrame{
	int [] unit = {50000,10000,5000,1000,500,100,50,10,1};
	private String[] str = {"금액", "오만원", "만원", "오천원", 
			"천원","오백원","백원","오십원","십원","일원"};
	private JLabel la = new JLabel();
	private JTextField[] tf = new JTextField[str.length];
	private JButton btn = new JButton("계산");
	
	public MoneyChanger() {
		setTitle("Money Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.pink);
		setLayout(null);
		
		la = new JLabel(str[0]);
		la.setSize(40, 20);
		la.setLocation(30,20);
		add(la);
		
		tf[0] = new JTextField(30);
		tf[0].setSize(100, 20);
		tf[0].setLocation(90, 20);
		add(tf[0]);
		
		btn.setSize(70, 20);
		btn.setLocation(200,20);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String input = tf[0].getText();
				if(input.length()==0)
					return;
				int money = Integer.parseInt(input);
				int m;
				
				for(int i=0; i<unit.length;i++) {
					m= money/unit[i];
					tf[i+1].setText(Integer.toString(m));
					if(m>0)
						money = money % unit[i];
				}
			}
		});
		add(btn);
				
				
				for(int i=1; i<str.length; i++) {
					la = new JLabel(str[i]);
					la.setHorizontalAlignment(JLabel.RIGHT);
					la.setSize(50,20);
					la.setLocation(50, 50+(i*20));
					
					tf[i] = new JTextField(30);
					tf[i].setHorizontalAlignment(JTextField.CENTER);
					tf[i].setSize(70, 20);
					tf[i].setLocation(120,50+(i*20));
					add(la);
					add(tf[i]);
				}
				setSize(300,300);
				setVisible(true);
			}

		
	
	
	public static void main(String[] args) {
		new MoneyChanger();
	}

}
