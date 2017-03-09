package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.market.responses.GetResponse;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.photos.PhotoUpload;
import com.vk.api.sdk.objects.photos.responses.GetMarketUploadServerResponse;
import com.vk.api.sdk.objects.photos.responses.MarketAlbumUploadResponse;
import com.vk.api.sdk.objects.photos.responses.MarketUploadResponse;
import com.vk.api.sdk.queries.market.MarketAddQuery;
import com.vk.api.sdk.queries.photos.PhotosSaveMarketAlbumPhotoQuery;

import java.io.File;
import java.util.List;

/**
 * Created by FDR on 09.03.2017.
 */
public class UploadToAlbumMarket {
    UserActor actor;

    public UploadToAlbumMarket(UserActor actor) {
        this.actor = actor;
    }

    public void uploadToAlbum() throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        int groupId = 141781394;
        GetMarketUploadServerResponse execute = vk.photos().getMarketUploadServer(actor, groupId)
                .mainPhoto(true).cropX(1).cropY(1).cropWidth(400).execute();
        String uploadUrl = execute.getUploadUrl();
        File file = new File("C:\\Users\\Fgolo\\Pictures\\Вело\\stels.jpg");
        MarketUploadResponse execute1 = vk.upload().photoMarket(uploadUrl, file).execute();

        List<Photo> execute2 = vk.photos().saveMarketPhoto(actor,
                execute1.getPhoto(),
                execute1.getServer(),
                execute1.getHash())
                .cropData(execute1.getCropData())
                .cropHash(execute1.getCropHash())
                .groupId(groupId)
                .execute();
        for (Photo photo : execute2) {
            Integer id = photo.getId();
            System.out.println(id);
            vk.market().add(actor, -groupId, "Velosiped", "skdnjfskjnfksjnfkjsnfkjnskjfnskj", 100, 15, id).execute();
        }

    }
}
