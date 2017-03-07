package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Chat;
import com.vk.api.sdk.objects.messages.Dialog;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.responses.GetDialogsResponse;
import com.vk.api.sdk.objects.messages.responses.GetResponse;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by FDR on 06.03.2017.
 */
public class InfoMessage {
    UserActor actor;

    public InfoMessage(UserActor actor) {
        this.actor = actor;
    }

    public void messageId() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        GetResponse execute = vk.messages().get(actor).execute();
        List<Message> items = execute.getItems();
        List<Integer> chatIds = items.stream().map(d -> d.getChatId()).distinct().collect(toList());
        for (Message item : items) {
            Integer message = item.getChatId();
            System.out.println(message);
        }


    }
}
