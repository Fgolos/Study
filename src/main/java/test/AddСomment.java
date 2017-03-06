package test;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.responses.CreateCommentResponse;
import com.vk.api.sdk.queries.wall.WallCreateCommentQuery;


/**
 * Created by FDR on 06.03.2017.
 */
//42298701
public class AddСomment {
    UserActor actor;

    public AddСomment(UserActor actor) {
        this.actor = actor;
    }

    public void addComment(String massege) throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        CreateCommentResponse commentQuery = vk.wall().createComment(actor, 42298701).message(massege).execute();
    }
}
