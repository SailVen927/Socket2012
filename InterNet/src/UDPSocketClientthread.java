import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPSocketClientthread implements Runnable {
	DatagramSocket datagramSocket;

	{
		try {
			datagramSocket = new DatagramSocket(8081);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	byte[] ibuf = new byte[1024];
	DatagramPacket datagramPacket = new DatagramPacket(ibuf, ibuf.length);

	@Override
	public void run() {
		while (true) {
			try {
				datagramSocket.receive(datagramPacket);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Tom£º" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
		}
	}
}
