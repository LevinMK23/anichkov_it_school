package rest;

import com.google.gson.Gson;

public class JsonTest {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(1, 2);

        Gson gson = new Gson();

        String json = gson.toJson(rectangle);
        System.out.println(json);

        Rectangle other = gson.fromJson(json, Rectangle.class);

        System.out.println(other);
    }
}
