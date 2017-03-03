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
        String response = example.run("http://ya.ru");
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





