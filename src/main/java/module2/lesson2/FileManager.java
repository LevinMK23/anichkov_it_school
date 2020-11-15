package module2.lesson2;

import java.io.*;

public class FileManager implements Writable, Readable {

    private String path;

    public FileManager(String path) {
        this.path = path;
    }

    @Override
    public String read() throws IOException {
        return new String(new FileInputStream(new File(path))
                .readAllBytes());
    }

    @Override
    public void write(String message) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(path), true);
        fos.write((message + "\n").getBytes());
        fos.flush();
    }
}
