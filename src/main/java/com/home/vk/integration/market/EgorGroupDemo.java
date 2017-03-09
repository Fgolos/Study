package com.home.vk.integration.market;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.market.responses.AddAlbumResponse;

public class EgorGroupDemo {
  public static void main(String[] args)
  throws ClientException, ApiException {
    final String accessToken
        = "93878d5b1038d33ce63e5a26895f90f77199058881277f3609f65a7619a3cb957b2a7fdb7525ebe834479";
    final int userId = 11055539;
    final UserActor userActor = new UserActor(userId, accessToken);
    final VkApiClient vk = VkFactory.getVk();
    final AddAlbumResponse addAlbum = vk.market()
        .addAlbum(userActor, -142098814, "test-album-name")
        .mainAlbum(true)
        .execute();
    System.out.println("Album market id " + addAlbum.getMarketAlbumId());
  }
}
