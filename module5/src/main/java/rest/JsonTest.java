package rest;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.jsfr.json.JsonDomBuilder;
import org.jsfr.json.JsonSurfer;

import java.util.Map;

import static net.minidev.json.parser.JSONParser.MODE_JSON_SIMPLE;

public class JsonTest {

    public static void main(String[] args) throws ParseException {

        Rectangle rectangle = new Rectangle(1, 2);

        Gson gson = new Gson();

        String json = gson.toJson(rectangle);
        System.out.println(json);

        Rectangle other = gson.fromJson(json, Rectangle.class);

        System.out.println(other);

        JSONObject obj = (JSONObject) new JSONParser(MODE_JSON_SIMPLE)
                .parse(json);

        System.out.println(obj);

    }
}
