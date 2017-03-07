package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Chat;
import com.vk.api.sdk.objects.messages.Dialog;
import com.vk.api.sdk.objects.messages.responses.GetDialogsResponse;
import com.vk.api.sdk.objects.messages.responses.GetResponse;
import com.vk.api.sdk.queries.messages.MessagesGetChatQuery;

import java.util.List;

/**
 * Created by FDR on 06.03.2017.
 */
public class ChatId {
    UserActor actor;

    public ChatId(UserActor actor) {
        this.actor = actor;
    }

    public Integer chatId() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        final GetDialogsResponse execute = vk.messages().getDialogs(actor).execute();
        final List<Dialog> items = execute.getItems();
        final Dialog dialog = items.get(0);
        final Integer chatId = dialog.getMessage().getChatId();
        return chatId;
    }

}
