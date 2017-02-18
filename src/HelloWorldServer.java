import java.io.IOException;

import org.jnetwork.ClientData;
import org.jnetwork.TCPConnection;
import org.jnetwork.TCPConnectionCallback;
import org.jnetwork.TCPServer;

public class HelloWorldServer implements TCPConnectionCallback {
	public static void main(String[] args) {
		TCPServer server = new TCPServer(1337, new HelloWorldServer());
		try {
			server.start();
			server.waitUntilClose();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clientConnected(ClientData event) {
		TCPConnection client = (TCPConnection) event.getConnection();
		try {
			String FromClient = (String) client.getInputStream().readObject();
			System.out.println(FromClient);
			client.getOutputStream().writeObject("Hi Wolrd");
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
