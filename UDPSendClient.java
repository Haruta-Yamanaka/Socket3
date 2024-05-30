package basic.KADAI;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPSendClient {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        DatagramSocket socket1 = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String message = "abc";
            byte[] sendData = message.getBytes();
            // 送信パケットを作成
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, 9876);
            socket.send(sendPacket);



            socket1 = new DatagramSocket(9000);
            byte[] receiveData = new byte[1024];

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket1.receive(receivePacket);

            String message2 = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("受信: " + message2);
            


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}

