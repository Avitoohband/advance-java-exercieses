import java.io.IOException;
import java.net.*;

public class Server {
    /*
    This class represent the Server
     */

    public static final int PORT = 8888;
    private ServerSocket sc= null;
    private Socket s = null;

    public Server (){
        try {
            sc = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Starts the server
    // calling for a new thread to handle a client
    public void startServer(){
        try {

            while(true){

                s = sc.accept();
                new ServerThread(s).start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                sc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }
}
