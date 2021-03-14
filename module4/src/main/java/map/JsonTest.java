package map;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class JsonTest {

    public static void main(String[] args) throws Exception {
        User user = new User("Ivan", "Ivanov", "23-06-1990");
        user.setChildren(List.of(
                new User("U1", "U1S", "1"),
                new User("U2", "U2S", "1")));
        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
        User newUser = gson.fromJson(json, User.class);
        System.out.println(newUser);

        String s = Files.lines(Path.of("module4/src/main/java/map/forParse.json"))
                .collect(Collectors.joining());
        System.out.println(s);
        JsonCore core = new JsonCore();
        User u = core.getObject(s, User.class);
        System.out.println(u);
    }
}
