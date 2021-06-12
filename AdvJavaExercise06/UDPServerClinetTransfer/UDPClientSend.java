import java.io.IOException;
import java.net.*;

public class UDPClientSend  extends Thread{
    /*
    This class represent the Udp client send messages Thread
     */

    public static final int MAX_MESSAGES = 10 ;
    private InetAddress IPAddress;
    private DatagramSocket socket;
    private String host;


    public UDPClientSend(String hostName, DatagramSocket socket){
        host = hostName;
        try {
            IPAddress = InetAddress.getByName(host); // send args[0] to here  - "localhost"
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
            this.socket = socket;
            System.out.println("|CLIENT IS READY - " + IPAddress.getHostName().toUpperCase() + "|");
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < MAX_MESSAGES; i++) { // sends 10 messages to the server
            sendToServer(i + 1);
        }
    }
    // Sends a message to the server with an id number.
    private void sendToServer(int IdSender){
        String response = "Id number - " + IdSender;
        byte[] dataToSend = new byte[1024];
        dataToSend = response.getBytes();
        DatagramPacket packet = new DatagramPacket(dataToSend , dataToSend.length, IPAddress, UDPServer.PORT);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

