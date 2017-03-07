package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.objects.messages.MessageAttachment;

/**
 * Created by FDR on 06.03.2017.
 */
public class SendMessage {
    UserActor actor;

    public SendMessage(UserActor actor) {
        this.actor = actor;
    }

    public void sendMessage(String message) throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        Integer execute = vk.messages().send(actor).peerId(11055539).message(message).execute();
    }
}

