//package com.home.vk.integration.market;
//
//import com.vk.api.sdk.client.actors.UserActor;
//import com.vk.api.sdk.exceptions.ApiException;
//import com.vk.api.sdk.exceptions.ClientException;
//
///**
// * Created by FDR on 07.03.2017.
// */
//public class MegaUploader {
//    UserActor actor;
//
//    public MegaUploader(UserActor actor) {
//        this.actor = actor;
//    }
//
//    public void savePhooAndComment(String pathToPhoto, String comment) throws ClientException, ApiException {
//        PhotoUploader photoUploader = new PhotoUploader(actor);
//        CommentSender commentSender = new CommentSender(actor);
//        photoUploader.uploadPhoto(pathToPhoto);
//        commentSender.commentSender(comment);
//    }
//}
