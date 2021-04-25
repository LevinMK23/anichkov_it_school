import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngine;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {


        Socket socket = new Socket("localhost", 8189); // 127.0.0.1
        DataInputStream is = new DataInputStream(socket.getInputStream());
        DataOutputStream os = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                while (true) {
                    String message = is.readUTF();
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.err.println("Server was broken");
                try {
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }).start();

        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String message = in.nextLine();

            if (!socket.isClosed()) {
                os.writeUTF(message);
                os.flush();
            }
        }
    }
}
