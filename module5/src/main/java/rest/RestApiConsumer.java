package rest;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Scanner;

public class RestApiConsumer {

    private static final String TOKEN = "pdct.1.1.20210425T071632Z.987f2db2a49877b1.f39c7d532ca40940d8be7d870affa5b7f2699c19";
    private static final String apiUrl = "https://predictor.yandex.net/api/v1/predict.json/complete";

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        System.out.println("Привет, ты находишься в Апи предиктора яндекса");
        System.out.println("Введи текст и нажми enter,  я скажу что ты хотел ввести)");
        System.out.println("Для выхода введи q");
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {

            String line  = in.nextLine();

            if (line.equals("q")) {
                break;
            }

            HttpUrl.Builder httpBuilder = HttpUrl.parse(apiUrl).newBuilder()
                    .addQueryParameter("lang", "ru")
                    .addQueryParameter("key", TOKEN)
                    .addQueryParameter("limit", "10")
                    .addQueryParameter("q", line);

            Request request = new Request.Builder()
                    .url(httpBuilder.build())
                    .build();

            Response response = client.newCall(request).execute();

            System.out.println("api result: " + response.body().string());

        }

    }
}
