package com.home.vk.integration.market;

import com.google.common.collect.ImmutableList;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.UserAuthResponse;
import static java.util.stream.Collectors.joining;
import java.util.Scanner;

public class UserAccessTokenResolver {
  private final Integer applicationId;

  private final String clientSecret;

  public UserAccessTokenResolver(final Integer applicationId, final String clientSecret) {
    this.applicationId = applicationId;
    this.clientSecret = clientSecret;
  }

  public void getToken()
  throws ClientException, ApiException {
    final String rootPath = "https://oauth.vk.com/authorize";
    final String params = ImmutableList.<String>builder()
        .add("friends")
        .add("notify")
        .add("photos")
        .add("audio")
        .add("video")
        .add("pages")
        .add("status")
        .add("+256")
        .add("notes")
        .add("messages")
        .add("wall")
        .add("ads")
        .add("offline")
        .add("docs")
        .add("groups")
        .add("notifications")
        .add("stats")
        .add("email")
        .add("market")
        .build()
        .stream().collect(joining(","));
    final String format = String
        .format("%s?client_id=%s&display=page&scope=%s&response_type=code&v=5.62",
            rootPath,
            applicationId,
            params);
    System.out.println("Enter link: " + format);
    final Scanner scanner = new Scanner(System.in);
    System.out.println("Enter received clientSecret from URL");
    final String code = scanner.next();
    final VkApiClient vkApi = VkFactory.getVk();
    UserAuthResponse authResponse = vkApi.oauth()
        .userAuthorizationCodeFlow(applicationId, clientSecret, "", code)
        .execute();
    System.out.println(
        "User id " + authResponse.getUserId() + " Token: " + authResponse.getAccessToken());
  }

  public static UserAccessTokenResolver egorTokenResolver()
  throws ClientException, ApiException {
    int appId = 5913440;
    String secret = "GbkOzbG4Aha0Iv7yVYgK";
    return new UserAccessTokenResolver(appId, secret);
  }


  public static void main(String[] args)
  throws ClientException, ApiException {
    final UserAccessTokenResolver userAccessTokenResolver = egorTokenResolver();
    userAccessTokenResolver.getToken();
  }
}
