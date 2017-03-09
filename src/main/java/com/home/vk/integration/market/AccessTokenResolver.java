package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;


/**
 * Created by FDR on 04.03.2017.
 */
public class AccessTokenResolver {
    public static void main(String[] args) throws ClientException, ApiException {

        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        int appId = 5908645;
        String code = "59ad56787d48f3b178";
        String clientSecret = "XAwD3qvLx5wWvCzc6vNj";
        String redirectURL = "";
        UserAuthResponse authResponse = vk.oauth()
                .userAuthorizationCodeFlow(appId, clientSecret, redirectURL, code)
                .execute();

        UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
        System.out.println(authResponse.getAccessToken());
        System.out.println(authResponse.getUserId());
    }
}
