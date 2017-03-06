package test;

import com.vk.api.sdk.actions.Wall;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FDR on 06.03.2017.
 */
public class Wallget {
    UserActor actor;

    public Wallget(UserActor actor) {
        this.actor = actor;
    }

    public void wallGet() throws ClientException, ApiException {
        //Нужно добавить массив для сохранения всех постов?
        ArrayList<Integer> mass = new ArrayList();
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        GetResponse idtest = (GetResponse) vk.wall().getById(actor, String.valueOf(mass)).execute();
    }
}
