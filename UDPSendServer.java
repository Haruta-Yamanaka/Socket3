package basic.KADAI;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPSendServer {

    public static void main(String[] args) {
        DatagramSocket socket = null;
        DatagramSocket socket1 = null;
        try {
            socket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];

            while (true) {
                // 受信パケットを作成
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("受信: " + message);


                //送信パケットの作成
                socket1 = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String message2 = message.toUpperCase();
            byte[] sendData = message2.getBytes();

            // 送信パケットを作成
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9000);
            socket1.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}
