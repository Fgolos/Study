package com.home.vk.integration.market;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by FDR on 09.03.2017.
 */
public class AllFiles {
    public List<Path> files() throws IOException {
        List<Path> collect = Files.walk(Paths.get("C:\\Users\\Fgolo\\Pictures\\Saved Pictures"))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
        return collect;
    }
}
