package test;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by FDR on 03.03.2017.
 */
public class User {

    OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        User example = new User();
        String t = "fbed6ed9ed627bcd15d499e33ad311715d61f38ff8242136df266103edb49ab5def307186a158587810fc";
        String response = example.run("https://api.vk.com/method/friends.getOnline?v=5.52&access_token=" + t);
        System.out.println(response);
    }

    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}





