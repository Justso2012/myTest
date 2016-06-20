package alex.per.TestNet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestAlwaysServer {
	public static void main(String args[]) {
		boolean IsDone = false;

		ServerSocket s;
		try {
			s = new ServerSocket(8189);
			// Socket incoming = s.accept();

			while (true) {
				Socket incoming = s.accept();
				Runnable r = new ClientThread(incoming);
				Thread t = new Thread(r);
				t.start();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}

class ClientThread implements Runnable {

	private Socket incoming;
	private boolean IsDone = false;

	public ClientThread(Socket incoming) {
		this.incoming = incoming;
	}

	@Override
	public void run() {
		try {
			try {

				InputStream in = incoming.getInputStream();
				OutputStream out = incoming.getOutputStream();

				Scanner scanIn = new Scanner(in);
				PrintWriter printOut = new PrintWriter(out, true);
				printOut.println("Welcome!Enter Bye to exit!");

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
			e.printStackTrace();
		}
	}

}
