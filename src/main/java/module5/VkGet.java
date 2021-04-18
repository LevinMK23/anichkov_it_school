package module5;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class VkGet {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("vk.com", 80);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        System.out.println("1");
        String request = "GET / HTTP/1.1\n" +
                "Host: vk.com\n" +
                "Cookie: remixlang=3";
        os.write(request.getBytes(StandardCharsets.UTF_8));
        os.flush();
        System.out.println(2);
        byte[] buffer = new byte[1024];

        int read;

        while (true) {
            read = is.read(buffer);
            System.out.println("*");
            if (read == - 1) {
                break;
            }
            String response = new String(buffer, 0, read);
            System.out.println(response);
        }
    }
}
