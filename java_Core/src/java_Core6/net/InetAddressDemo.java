package java_Core6.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) {
		
		try {
			
			InetAddress address = InetAddress.getByName("www.baidu.com");
			System.out.println(address.getHostAddress());
		
			System.out.println(address.getHostName());
			
			InetAddress address1 = InetAddress.getByName("he-PC");
			System.out.println(address1.getHostAddress());
			
			System.out.println("===========================");
			InetAddress address2 = InetAddress.getLocalHost();
			System.out.println(address2.getHostName());
			System.out.println(address2.getHostAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}

}
