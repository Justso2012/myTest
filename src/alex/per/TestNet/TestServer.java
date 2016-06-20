package alex.per.TestNet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer {
	public static void main(String args[]) {
		boolean IsDone = false;

		ServerSocket s;
		try {
			s = new ServerSocket(8189);

			Socket incoming = s.accept();

			try {

				InputStream in = incoming.getInputStream();
				OutputStream out = incoming.getOutputStream();

				Scanner scanIn = new Scanner(in);
				PrintWriter printOut = new PrintWriter(out, true);
				printOut.println("Hello world!Enter Bye to exit!");

				while (!IsDone && scanIn.hasNextLine()) {
					String line = scanIn.nextLine();
					printOut.println("Echo:" + line);
					if (line.trim().equals("Bye"))
						IsDone = true;
				}
			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
