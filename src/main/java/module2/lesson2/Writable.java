package module2.lesson2;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    void write(String message) throws IOException;
}
