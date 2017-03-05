//package test;
//
//import com.vk.api.sdk.actions.Wall;
//import com.vk.api.sdk.client.TransportClient;
//import com.vk.api.sdk.client.VkApiClient;
//import com.vk.api.sdk.client.actors.UserActor;
//import com.vk.api.sdk.httpclient.HttpTransportClient;
//import com.vk.api.sdk.queries.wall.WallCreateCommentQuery;
//
///**
// * Created by FDR on 05.03.2017.
// */
//public class CommentSender {
//    UserActor actor;
//
//    public CommentSender(UserActor actor) {
//        this.actor = actor;
//    }
//
//    public void commentSender(String massage) {
//        TransportClient transportClient = HttpTransportClient.getInstance();
//        VkApiClient vk = new VkApiClient(transportClient);
//
//        WallCreateCommentQuery wallCreateCommentQuery= wallCreateCommentQuery.message(massage);
//
//    }
//}
