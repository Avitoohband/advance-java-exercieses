import java.net.*;
import java.io.*;

public class ServerThread extends Thread{
    /*
    This class represent the Server Thread
     */
    private Socket s = null;

    public ServerThread(Socket s){
        this.s = s;
    }

    @Override
    public void run() {
        super.run();

        try{
            handleReadAndWrite();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    //  Receives an object with the desired amount amount and type of currency
    // to exchange from the client.
    // Sends back to the client the the exchange amount.
    private void handleReadAndWrite() throws Exception{
        ExchangeRate exchange = new ExchangeRate();

        OutputStream outputStream = s.getOutputStream();
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        InputStream inputStream = s.getInputStream();
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);

        Request req;
        req = (Request) objInputStream.readObject();
        double rate = exchange.rate(req.getCurrencyCurrentType(), req.getCurrencyDesiredType());
        req.setReturningAmount(req.getCustomerCurrentAmount() * rate);

        objOutputStream.writeObject(req);

        objInputStream.close();
        inputStream.close();
        objOutputStream.close();
        outputStream.close();
        s.close();
    }
}
