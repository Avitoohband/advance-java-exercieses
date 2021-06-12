import java.io.IOException;
import java.net.*;
import java.util.*;

public class UDPClientReceive extends Thread{
    /*
    This class represent the Udp client that receives response back
    from the server
     */

    private final int RECEIVE_TIMEOUT = 10000;

    private DatagramSocket socket;
    private List messageList;


    public UDPClientReceive(DatagramSocket socket) {
        this.socket = socket;
        messageList = new ArrayList<String>();

    }
    // Gets a response from the server
    // and adds it to an array
    private void getFromServer(){
        byte[] receiveData = new byte[1024];

        DatagramPacket packet = new DatagramPacket(receiveData, receiveData.length);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String receivedFromServer = new String(packet.getData()).substring(0,packet.getData().length);
        messageList.add(receivedFromServer);
    }

    @Override
    public void run()
    {
        super.run();
        try {
            socket.setSoTimeout(RECEIVE_TIMEOUT);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < UDPClientSend.MAX_MESSAGES; i++) { // attempt to the gets messages from the server
            getFromServer();
        }
        for (int i = 0; i < messageList.size(); i++) { // print the messages that received back
            System.out.println(messageList.get(i));
        }
        System.out.println("Messages received back from Server: " + messageList.size()); // prints the messages amount
    }
}
