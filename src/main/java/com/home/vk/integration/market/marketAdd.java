package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.queries.market.MarketAddQuery;

/**
 * Created by FDR on 07.03.2017.
 */
public class marketAdd {
    UserActor actor;

    public marketAdd(UserActor actor) {
        this.actor = actor;
    }
   public void addProduct() throws ClientException, ApiException {
       TransportClient transportClient = HttpTransportClient.getInstance();
       VkApiClient vk = new VkApiClient(transportClient);
       PhotoUploader photoUploader=new PhotoUploader(actor);
//       MarketAddQuery velo2 = vk.market().add(
//               actor,
//               141781394,
//               "Velo2",
//               "Velosiped gorniy",
//               1,
//               555,
//               photoUploader.uploadPhoto("C:\\Users\\Fgolo\\Pictures\\Для мамы\\1.jpg")
//       );
   }
}
