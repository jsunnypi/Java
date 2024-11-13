import java.net.InetAddress;


public class AddressTest {

	public static void main(String[] args) throws Exception {
		
		/*
		InetAddress ia = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터 이름 : " + ia.getHostName());
		System.out.println("내 컴퓨터 IP 주소 : " + ia.getHostAddress());
		*/
		
		InetAddress ib[] = InetAddress.getAllByName("www.naver.com");
		for(int i=0; i<ib.length; i++) {
			System.out.println(ib[i]);
		}
	}

}
