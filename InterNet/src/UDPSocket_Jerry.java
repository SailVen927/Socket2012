public class UDPSocket_Jerry {
	public static void main(String[] args) {
		// �ֱ���������Ϣ�̺߳�����Ϣ�߳�
		Thread thread1 = new Thread(new UDPSocketClientthread());
		Thread thread2 = new Thread(new UDPSocketServerthread());
		thread1.start();
		thread2.start();
	}
}
