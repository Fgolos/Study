package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.photos.responses.MarketUploadResponse;
import com.vk.api.sdk.queries.upload.UploadPhotoMarketQuery;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by FDR on 08.03.2017.
 */
public class PhotoMarketUploaderServer {
    UserActor actor;

    public PhotoMarketUploaderServer(UserActor actor) {
        this.actor = actor;
    }

    public int uploadPhoto(File file) throws ClientException, ApiException, IOException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);

        String uploadUrl = vk
                .photos()
                .getMarketUploadServer(actor, 141781394)
                .mainPhoto(true)
                .cropX(0)
                .cropY(0)
                .cropWidth(400)
                .execute()
                .getUploadUrl();

        MarketUploadResponse marketUploadResponse = new UploadPhotoMarketQuery(vk, uploadUrl, file)
                .execute();

        List<Photo> photos = vk.photos().saveMarketPhoto(
                actor,
                marketUploadResponse.getPhoto(),
                marketUploadResponse.getServer(),
                marketUploadResponse.getHash()
        ).execute();

        System.out.println(marketUploadResponse);

        return -1;


    }
}
