package Example;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;



public class DigitalClock extends JFrame{
	private JLabel label;
	
	class MyThread extends Thread{
		public void run() {
			Calendar now = Calendar.getInstance();
			int h = now.get(Calendar.HOUR_OF_DAY);
			int m = now.get(Calendar.MINUTE);
			int s = now.get(Calendar.SECOND);
			String time = h+":"+m+":"+s;
			
			for(;;) {
				label.setText(Integer.toString(h)+":"+ (Integer.toString(m)+":"+(Integer.toString(s))));
				s++;
				if(s==60) {
					s=0;
					m++;
				}
				if(m==60) {
					m=0;
					h++;
				}
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				label.setText(time);
			}
		}
	}
	
	public DigitalClock() {
		setTitle("digital clock");
		setSize(450, 300);
		label = new JLabel();
		label.setFont(new Font("Gothic", Font.ITALIC, 80));
		add(label);
		setVisible(true);
		(new MyThread()).start();
	}
	
	public static void main(String[] args) {
		new DigitalClock();
	}

}
