import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientEx {
	// 통신을 하기 위한 소켓이 필요( 서버 주소(IP) + 포트 )
	Socket socket;

	final String IP = "192.168.0.16";
	final int PORT = 9000;
	
	BufferedReader reader;
	BufferedWriter writer;

	public ClientEx() {
		initData();
	}

	private void initData() {
		try {
			socket = new Socket(IP, PORT);
			
			reader = new BufferedReader(new InputStreamReader(System.in));
			
			String input = reader.readLine();
			
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.write(input);
			writer.newLine(); // 문장의 끝을 알려주어야 함 
			writer.flush(); 
			
			
			
		} catch (Exception e) {
			
		}
	}

	public static void main(String[] args) {
		new ClientEx();
	}

}
