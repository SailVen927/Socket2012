package tom;


public class UDPSocket_Tom {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new UDPSocketClientthread());
        Thread thread2 = new Thread(new UDPSocketServerthread());
        thread1.start();
        thread2.start();
    }
}
