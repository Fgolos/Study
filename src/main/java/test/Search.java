package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by FDR on 15.03.2017.
 */
public class Search {
    String path;
    String filename;

    public Search(String path, String filename) {
        this.path = path;
        this.filename = filename;
    }

    public ArrayList<File> search() {
        File[] file = new File(path).listFiles();
        ArrayList<File> result = new ArrayList();
        for (File file1 : file) {
            if (file1.getName().contains(filename)) {
                result.add(file1);
            }
        }
        return result;
    }
}