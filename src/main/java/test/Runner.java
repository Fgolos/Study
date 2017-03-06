package test;

import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.WallpostFull;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

import java.util.List;

/**
 * Created by FDR on 05.03.2017.
 */
public class Runner {
    public static void main(String[] args) throws ClientException, ApiException {
        int id = 42298701;
        String token = "457c9456950dfa186d819f106317b3557988aea5c29cc66d8f7c91e5a6e8803a8aca6bda5cf5a1ac6a6c1";
        UserActor actor = new UserActor(id, token);
        //загрузка фото
//        PhotoUploader photoUploader = new PhotoUploader(actor);
//        photoUploader.uploadPhoto("C:\\Users\\Fgolo\\Pictures\\Для мамы\\3.jpg");

        //запись на стену
//        CommentSender commentSender=new CommentSender(actor);
//        commentSender.commentSender("sdsd");
        //Добавить коментарий к записи на стене. НЕ РАБОТАЕТ!
//        AddСomment addСomment = new AddСomment(actor);
//        addСomment.addComment("test");

        //получить список ИД постов со стены
//        Wallget wallget = new Wallget(actor);
//        final GetResponse wallpostFulls = wallget.wallGet();
//        final List<WallpostFull> items = wallpostFulls.getItems();
//        for (int i = 0; i < items.size(); i++) {
//            final WallpostFull wallpostFull = items.get(i);
//            System.out.println(wallpostFull.getId());
//       }
        //Комент к записи.
//        AddСomment addСomment = new AddСomment(actor);
//        addСomment.addComment("hello");
        //Посыл сообщения
//        SendMessage sendMessage = new SendMessage(actor);
//        sendMessage.sendMessage("Как дела");
        Likes likes = new Likes(actor);
        likes.likes();


    }
}
