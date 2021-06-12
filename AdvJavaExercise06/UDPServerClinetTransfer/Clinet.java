import java.net.*;

public class Clinet {
    /*
    This class represent the Client, create a socket for both of the
    Send and Receive Threads and starts them.
     */
    public static void main(String[] args) {

        String host;
        DatagramSocket clientSocket = null;

        if (args.length > 0) host = args[0];
        else{
            host = "localhost";
        }
        try {
            clientSocket = new DatagramSocket();
            UDPClientSend clientSend = new UDPClientSend(host, clientSocket);
            UDPClientReceive clientReceive = new UDPClientReceive(clientSocket);
            clientSend.start();
            clientReceive.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
