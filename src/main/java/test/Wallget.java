package test;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.WallpostFull;
import java.util.List;

/**
 * Created by FDR on 06.03.2017.
 */
public class Wallget {
    UserActor actor;

    public Wallget(UserActor actor) {
        this.actor = actor;
    }

    public List<WallpostFull> wallGet() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        return vk.wall().getById(actor).execute();
    }
}
