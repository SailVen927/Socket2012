import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSocketServerthread implements Runnable {
	byte[] ibuf = new byte[1024];
	String message;
	Scanner scanner = new Scanner(System.in);
	DatagramPacket datagramPacket;

	{
		try {
			datagramPacket = new DatagramPacket(ibuf, ibuf.length, InetAddress.getByName("127.0.0.1"), 2020);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	DatagramSocket ds;

	{
		try {
			ds = new DatagramSocket(8080, InetAddress.getByName("127.0.0.1"));
		} catch (SocketException | UnknownHostException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			message = scanner.nextLine();
			datagramPacket.setData(message.getBytes());
			try {
				assert ds != null;
				ds.send(datagramPacket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
