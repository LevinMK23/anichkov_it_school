package rest;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

public class VkApiTest {

    public static void main(String[] args) {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

//        UserAuthResponse authResponse = vk.oAuth()
//                .userAuthorizationCodeFlow(APP_ID, CLIENT_SECRET, REDIRECT_URI, code)
//                .execute();

//        UserActor actor = new UserActor(authResponse.getUserId(),
//                authResponse.getAccessToken());
    }
}


