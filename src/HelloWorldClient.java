import java.io.IOException;

import org.jnetwork.TCPConnection;

public class HelloWorldClient {
	public static void main(String[] args) {
		try {
			TCPConnection client = new TCPConnection("localhost", 1337);
			client.getOutputStream().writeObject("Hello World");
			String msgBack = (String) client.getInputStream().readObject();
			System.out.println(msgBack);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
