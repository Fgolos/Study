package com.home.vk.integration.market;

import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.wall.WallpostFull;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
//393d4ff079e65ed52a260e2fb15b4ed7d3a79268b7187dcf754a281e22cab931750f1a5ceaa7310d42e0c
/**
 * Created by FDR on 05.03.2017.
 */
public class Runner {
    public static void main(String[] args) throws ClientException, ApiException, IOException, URISyntaxException {
        int id = 42298701;
        String token = "dbf7777e4a312db78934feef6df946c6ec833e83e8c668d841a99cb7503e3a1659d35522aa44964b8bf10";
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
        //Wallget wallget = new Wallget(actor);
        //final GetResponse wallpostFulls = wallget.wallGet();
        //final List<WallpostFull> items = wallpostFulls.getItems();
        //for (int i = 0; i < items.size(); i++) {
         //   final WallpostFull wallpostFull = items.get(i);
         //   System.out.println(wallpostFull.getId());
//       //}
            //Комент к записи.
//        AddСomment addСomment = new AddСomment(actor);
//        addСomment.addComment("hello");
            //Посыл сообщения
//        SendMessage sendMessage = new SendMessage(actor);
//        sendMessage.sendMessage("Как дела");
            //Добавляет лайк в посте на стене
//        Likes likes = new Likes(actor);
//        likes.likes();

//        ChatId chatId = new ChatId(actor);
//        System.out.println(chatId.chatId());
            //Создать чат
//        CreatChat creatChat = new CreatChat(actor);
//        creatChat.creatChat();
        //InfoMessage infoMessage = new InfoMessage(actor);
        //infoMessage.messageId();

        File file = Paths.get(Runner.class.getResource("/1.jpg").toURI()).toFile();
        new PhotoMarketUploaderServer(actor).uploadPhoto(file);

        }
    }

