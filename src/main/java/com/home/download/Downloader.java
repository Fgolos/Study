package com.home.download;


import com.google.common.io.ByteSink;
import com.google.common.io.Files;
import okhttp3.Request;
import okhttp3.Response;


import java.io.File;
import java.io.IOException;

/**
 * Created by FDR on 12.05.2017.
 */
public class Downloader {
    public static void main(String[] args) throws IOException {
        downloadAllPictures();
    }

    public static byte[] dowloadBytesFromUrl(String url) throws IOException {
        okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        byte[] body = response.body().bytes();
        return body;
    }

    public static void convertBytesToFile(String name, byte[] body) throws IOException {
        File file = new File("C:\\Users\\Fgolo\\Desktop\\magnum\\" + name);
        ByteSink sink = Files.asByteSink(file);
        sink.write(body);
    }

    public static void downloadAllPictures() throws IOException {
        for (int i = 1; i <= 36; i++) {
            String pictureId = String.format("%03d%n", i);
            String url = "http://cz.author.eu/data/u_rotoskop/2017/42876802_magnum_29/42876802_magnum_29_" + pictureId + ".jpg";
            convertBytesToFile(i + ".jpg", dowloadBytesFromUrl(url));
        }
    }
}


