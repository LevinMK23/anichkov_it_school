import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public EchoServer() {
        try {
            ServerSocket server = new ServerSocket(8189);
            System.out.println("Server started!");
            while (true) {
                Socket socket = server.accept(); // block
                System.out.println("Client accepted, ip: " + socket.getInetAddress());
                ClientHandler handler = new ClientHandler(socket, this);
                new Thread(handler).start();
            }
        } catch (Exception e) {
            System.err.println("Server was broken");
        }
    }

    public static void main(String[] args) {
        new EchoServer();
    }
}
