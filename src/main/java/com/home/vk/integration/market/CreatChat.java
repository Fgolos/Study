package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;

import java.util.ArrayList;

/**
 * Created by FDR on 06.03.2017.
 */
public class CreatChat {
    UserActor actor;

    public CreatChat(UserActor actor) {
        this.actor = actor;
    }

    public void creatChat() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        ArrayList<Integer> friends = new ArrayList<>();
        friends.add(2803702);
        friends.add(11055539);
        vk.messages().createChat(actor, friends).title("Проба пера").execute();

    }


}
