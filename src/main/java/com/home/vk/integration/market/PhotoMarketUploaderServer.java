package com.home.vk.integration.market;

import com.vk.api.sdk.actions.Users;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.photos.responses.GetMarketUploadServerResponse;
import com.vk.api.sdk.objects.photos.responses.MarketUploadResponse;
import com.vk.api.sdk.objects.wall.PostedPhoto;
import com.vk.api.sdk.queries.market.MarketAddQuery;
import com.vk.api.sdk.queries.photos.PhotosGetMarketUploadServerQuery;
import com.vk.api.sdk.queries.upload.UploadPhotoMarketQuery;
import org.apache.commons.collections4.Get;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
        vk.photos().saveMarketPhoto(actor, photo, server, cropHash).execute();
        System.out.println(server);
        System.out.println(photo);
        System.out.println(cropData);
        System.out.println(cropHash);


//        vk.market().add(actor,
//                -141781394, "Велосипед",
//                "Отличный велосипед", 1, 54545,)

    }
}
