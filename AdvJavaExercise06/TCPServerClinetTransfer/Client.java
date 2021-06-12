import java.io.*;
import java.net.*;

public class Client extends Thread{
    /*
    This class represent the Client Thread
     */

    private ClientGui g;
    private String ip;
    private Request req;

    public Client(ClientGui g, String ip, Request req){
        this.g = g;
        this.ip = ip;
        this.req = req;
    }
    @Override
    public void run(){
        super.run();

        try{
            handleReadAndWrite();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    //  Sends an object with the desired amount amount and type of currency
    // to exchange.
    // Receives back from the server the the exchange amount and updates the gui.
    private void handleReadAndWrite() throws Exception{
        Socket s;

        s = new Socket(ip, Server.PORT);
        OutputStream outputStream = s.getOutputStream();
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        InputStream inputStream = s.getInputStream();
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

        objOutputStream.writeObject(req);

        Request returningReq;
        returningReq = (Request) objInputStream.readObject();
        g.setReturningAmount(String.format("%.2f", returningReq.getReturningAmount()));

        inputStream.close();
        objInputStream.close();
        outputStream.close();
        objOutputStream.close();
        s.close();
    }
}
