package rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.jsfr.json.*;
import org.jsfr.json.provider.JacksonProvider;

import java.util.Map;

import static net.minidev.json.parser.JSONParser.MODE_JSON_SIMPLE;

public class JsonTest {

    public static void main(String[] args) throws ParseException {

        Rectangle rectangle = new Rectangle(1, 2);

        Gson gson = new Gson();

        String json = gson.toJson(rectangle);
        //System.out.println(json);

        Rectangle other = gson.fromJson(json, Rectangle.class);

        // System.out.println(other);

        JSONObject obj = (JSONObject) new JSONParser(MODE_JSON_SIMPLE)
                .parse(json);

        //System.out.println(obj);

        JsonSurfer surfer = new JsonSurfer(
                JacksonParser.INSTANCE,
                JacksonProvider.INSTANCE
        );

        String response = "{\n" +
                "  \"response\": {\n" +
                "    \"GeoObjectCollection\": {\n" +
                "      \"metaDataProperty\": {\n" +
                "        \"GeocoderResponseMetaData\": {\n" +
                "          \"request\": \"Санкт-Петербург, 1\",\n" +
                "          \"results\": \"10\",\n" +
                "          \"found\": \"1\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"featureMember\": [\n" +
                "        {\n" +
                "          \"GeoObject\": {\n" +
                "            \"metaDataProperty\": {\n" +
                "              \"GeocoderMetaData\": {\n" +
                "                \"precision\": \"other\",\n" +
                "                \"text\": \"Россия, Санкт-Петербург\",\n" +
                "                \"kind\": \"locality\",\n" +
                "                \"Address\": {\n" +
                "                  \"country_code\": \"RU\",\n" +
                "                  \"formatted\": \"Россия, Санкт-Петербург\",\n" +
                "                  \"Components\": [\n" +
                "                    {\n" +
                "                      \"kind\": \"country\",\n" +
                "                      \"name\": \"Россия\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"kind\": \"province\",\n" +
                "                      \"name\": \"Северо-Западный федеральный округ\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"kind\": \"province\",\n" +
                "                      \"name\": \"Санкт-Петербург\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                      \"kind\": \"locality\",\n" +
                "                      \"name\": \"Санкт-Петербург\"\n" +
                "                    }\n" +
                "                  ]\n" +
                "                },\n" +
                "                \"AddressDetails\": {\n" +
                "                  \"Country\": {\n" +
                "                    \"AddressLine\": \"Россия, Санкт-Петербург\",\n" +
                "                    \"CountryNameCode\": \"RU\",\n" +
                "                    \"CountryName\": \"Россия\",\n" +
                "                    \"AdministrativeArea\": {\n" +
                "                      \"AdministrativeAreaName\": \"Санкт-Петербург\",\n" +
                "                      \"Locality\": {\n" +
                "                        \"LocalityName\": \"Санкт-Петербург\"\n" +
                "                      }\n" +
                "                    }\n" +
                "                  }\n" +
                "                }\n" +
                "              }\n" +
                "            },\n" +
                "            \"name\": \"Санкт-Петербург\",\n" +
                "            \"description\": \"Россия\",\n" +
                "            \"boundedBy\": {\n" +
                "              \"Envelope\": {\n" +
                "                \"lowerCorner\": \"30.043373 59.744311\",\n" +
                "                \"upperCorner\": \"30.566426 60.090917\"\n" +
                "              }\n" +
                "            },\n" +
                "            \"Point\": {\n" +
                "              \"pos\": \"30.315868 59.939095\"\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  }\n" +
                "}";

        surfer.configBuilder()
                .bind("$.response.GeoObjectCollection.featureMember[0].GeoObject.Point",
                        (value, context) -> {
                            ObjectNode node = (ObjectNode) value;
                            System.out.println(value);
                            System.out.println(value.getClass());
                        })
                .buildAndSurf(response);

    }
}
