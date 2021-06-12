import java.io.IOException;
import java.net.*;

public class UDPServer {
    /*
    This class represent the Udp server
     */

    public static final int PORT = 8888;
    private DatagramSocket serverSocket = null;

    public UDPServer( ){
        try{
            serverSocket = new DatagramSocket(PORT);
            System.out.println("|SERVER IS READY|");
        }
        catch(SocketException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
    // Gets a message from the client, gets the ip address and the port
    // and sends a response to the client
    public void sendAndReceive(){

        while(true){
            // receive from client
            byte[] receive = new byte[1024];
            DatagramPacket packet = new DatagramPacket(receive, receive.length);
            try {
                serverSocket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // send to client
            String msg = new String(packet.getData()).substring(0, packet.getLength());
            int p = packet.getPort();
            InetAddress add = packet.getAddress();
            System.out.println("Message received from Client |" + add.getHostName() + "| " + msg);
            msg =  "Server response for " + add.getHostName() + ": " + msg;
            packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, add, p);
            try {
                serverSocket.send(packet);
            } catch (IOException e) { // might need to be running for 10 times b4 close
                e.printStackTrace();
                serverSocket.close();
            }
        }
    }

    public static void main(String[] args) {
        UDPServer udpServer = new UDPServer();
        udpServer.sendAndReceive();
    }
}
