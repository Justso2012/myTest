package alex.per.TestNet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String args[]) {
		try {
			if (args.length > 0) {
				String host = args[0];

				InetAddress[] addresses = InetAddress.getAllByName(host);
				for (InetAddress add : addresses) {
					System.out.println("add:" + add);
				}
			} else {
				InetAddress localhost = InetAddress.getLocalHost();
				System.out.println("local_add:"+localhost);

			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
