package test;

import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

/**
 * Created by FDR on 05.03.2017.
 */
public class Runner {
    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) throws ClientException, ApiException {
        int id = 42298701;
        String token = "97bc7675902d63a434d0abaf1b990e4ee7e1c9633dc5e908b44b05cb5116ca7d4ae050780aae0fc78a940";
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
        Wallget wallget = new Wallget(actor);
        Wallget test = wallget;
        System.out.println(test);

    }
}
