package test;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.likes.responses.AddResponse;
import com.vk.api.sdk.queries.likes.LikesType;

/**
 * Created by FDR on 06.03.2017.
 */
public class Likes {
    UserActor actor;

    public Likes(UserActor actor) {
        this.actor = actor;
    }

    public void likes() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        AddResponse execute = vk.likes().add(actor, LikesType.POST, 489).execute();
    }
}
