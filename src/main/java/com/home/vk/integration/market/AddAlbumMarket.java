package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.market.responses.AddAlbumResponse;

/**
 * Created by FDR on 09.03.2017.
 */
public class AddAlbumMarket {
    UserActor actor;

    public AddAlbumMarket(UserActor actor) {
        this.actor = actor;
    }

    public void addAlbumMarket() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        AddAlbumResponse test = vk.market()
                .addAlbum(actor, -141781394, "Test")
                .mainAlbum(true)
                .execute();
    }
}
