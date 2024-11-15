package chatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGui extends JFrame implements ActionListener, Runnable {

	Container container = getContentPane();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	JTextField textField = new JTextField();

	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String str;	// 채팅 문자열 저장

	public ClientGui(String ip, int port) {
		setTitle("챗팅");
		setSize(550, 400);
		setLocation(400, 400);
		init();
		start();
		setVisible(true);
		
		// 통신 초기화
		initNet(ip, port);
		System.out.println("ip = " + ip);
	}

	// 통신 초기화
	private void initNet(String ip, int port) {
		try {
			// 서버에 접속 시도
			socket = new Socket(ip, port);
			
			// 통신용 input, output 클래스 설정
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch(UnknownHostException e) {
			System.out.println("IP 주소가 다릅니다.");
		} catch(IOException e) {
			System.out.println("접속 실패");
		}
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center", scrollPane);
		container.add("South", textField);
	}
	
	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		textField.addActionListener(this);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				str = in.readLine();
				textArea.append(str + "\n");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// textField의 문자열을 읽어와서 서버로 전송함
		str = textField.getText();
		out.println(str);
		// textField 초기화
		textField.setText("");
	}

}
