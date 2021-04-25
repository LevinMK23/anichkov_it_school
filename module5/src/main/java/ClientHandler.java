import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private final Socket socket;

    public ClientHandler(Socket socket, EchoServer server) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connection alive....");
            while (true) {
                String message = is.readUTF();
                System.out.println("received: " + message);
                os.writeUTF("from server: " + message);
                os.flush();
            }
        } catch (Exception e) {
            System.err.println("Client disconnected");
        }
    }
}
