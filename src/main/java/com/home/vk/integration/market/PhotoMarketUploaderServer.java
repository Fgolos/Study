package com.home.vk.integration.market;


import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.photos.responses.GetMarketUploadServerResponse;
import com.vk.api.sdk.objects.photos.responses.MarketUploadResponse;
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

    public void uploadPhotoMarket() throws ClientException, ApiException, IOException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        GetMarketUploadServerResponse execute = vk.photos()
                .getMarketUploadServer(actor, 141781394)
                .cropX(0)
                .cropY(0)
                .cropWidth(400)
                .mainPhoto(true)
                .execute();
        String uploadUrl = execute.getUploadUrl();
        File file = new File("C:\\Users\\Fgolo\\Pictures\\1.jpg");
        MarketUploadResponse uploadPhotoMarketQuery = vk.upload().photoMarket(uploadUrl, file).execute();
        Integer server = uploadPhotoMarketQuery.getServer();
        String photo = uploadPhotoMarketQuery.getPhoto();
        String cropData = uploadPhotoMarketQuery.getCropData();
        String cropHash = uploadPhotoMarketQuery.getCropHash();
        List<Photo> photoList = vk.photos().saveMarketPhoto(actor, photo, server, cropHash).execute();
        Integer id = photoList.get(1).getId();
        vk.market().add(actor, 141781394, "Велосипед", "Хороший велосипед", 1, 564687, id).execute();



    }
}
