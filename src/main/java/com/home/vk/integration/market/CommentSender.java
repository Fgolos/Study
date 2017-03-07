package com.home.vk.integration.market;

import com.vk.api.sdk.actions.Wall;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.photos.responses.GetResponse;
import com.vk.api.sdk.objects.wall.Wallpost;
import com.vk.api.sdk.objects.wall.responses.PostResponse;
import com.vk.api.sdk.queries.wall.WallCreateCommentQuery;
import com.vk.api.sdk.queries.wall.WallGetQuery;
import com.vk.api.sdk.queries.wall.WallPostQuery;

/**
 * Created by FDR on 05.03.2017.
 */
public class CommentSender {
    UserActor actor;

    public CommentSender(UserActor actor) {
        this.actor = actor;
    }

    public void commentSender(String message) throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        PostResponse wallpost = vk.wall().post(actor).message(message).execute();


    }
}
