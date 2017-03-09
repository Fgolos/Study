package com.home.vk.integration.market;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;

public class VkFactory {
  public static VkApiClient getVk() {
    TransportClient transportClient = HttpTransportClient.getInstance();
    VkApiClient vk = new VkApiClient(transportClient);
    return vk;
  }
}
