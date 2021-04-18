package module5;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class OkHttpVkTest {

    public static void main(String[] args) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://vk.com")
                .build();

        System.out.println(request.httpUrl());
        System.out.println(request);

        Response response = client.newCall(request).execute();
        System.out.println(response);
        System.out.println(response.body().string());
    }
}
