package chatting;

import java.net.InetAddress;

public class ClientGuiMain {

	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			String ip_str = ia.toString();
			String ip = ip_str.substring(ip_str.indexOf("/") + 1);
			new ClientGui(ip, 5420);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

