package test;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.photos.Photo;
import com.vk.api.sdk.objects.photos.PhotoUpload;
import com.vk.api.sdk.objects.photos.responses.GetResponse;
import com.vk.api.sdk.objects.photos.responses.WallUploadResponse;
import com.vk.api.sdk.objects.wall.responses.PostResponse;

import java.io.File;
import java.util.List;

/**
 * Created by FDR on 05.03.2017.
 */
public class PhotoUploader {
    public static void main(String[] args) throws ClientException, ApiException {
        TransportClient transportClient = HttpTransportClient.getInstance();
        VkApiClient vk = new VkApiClient(transportClient);
        int id = 42298701;
        String token = "d627a094d938fb53965c8e2582a8d2cbee388b49192e72109480a94018fff4685426e30ac4fa22e26e4b6";
        UserActor actor = new UserActor(id, token);
        PhotoUpload serverResponse = vk.photos().getWallUploadServer(actor).execute();
        File file = new File("C:\\Users\\Fgolo\\Pictures\\1.jpg");
        WallUploadResponse uploadResponse = vk.upload().photoWall(serverResponse.getUploadUrl(), file).execute();
        List<Photo> photoList = vk.photos().saveWallPhoto(actor, uploadResponse.getPhoto())
                .server(uploadResponse.getServer())
                .hash(uploadResponse.getHash())
                .execute();

        Photo photo = photoList.get(0);
        String attachId = "photo" + photo.getOwnerId() + "_" + photo.getId();
        PostResponse getResponse = vk.wall().post(actor)
                .attachments(attachId)
                .execute();

    }
}
