package com.home.usaTravel;


import com.google.common.io.Files;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Created by FDR on 15.05.2017.
 */
public class PriceEntryParser {
    public static void main(String[] args) throws IOException {
        // System.out.println(parseFromFile("trati.csv"));
        System.out.println(calculate("trati.csv", "food"));
        System.out.println(calculate("trati.csv", "gas"));
    }


    public static ArrayList<PriceEntry> parseFromFile(String fileName) throws IOException {
        File file = new File("C:\\Users\\Fgolo\\Desktop\\" + fileName);
        ArrayList<PriceEntry> parseFile = new ArrayList<>();
        List<String> mass = Files.readLines(file, UTF_8);
        for (int i = 1; i < mass.size(); i++) {
            String[] split = mass.get(i).split(";");
            String data = split[0];
            String description = split[1];
            split[2] = split[2].replace(',', '.');
            Double price = Double.parseDouble(split[2]);
            PriceEntry priceEntry = new PriceEntry(data, description, price);
            parseFile.add(priceEntry);
        }
        return parseFile;
    }

    public static Double calculate(String fileName, String item) throws IOException {
        ArrayList<PriceEntry> calc = parseFromFile(fileName);
        Double res = 0.0;
        for (int i = 0; i < calc.size(); i++) {
            if (calc.get(i).description.contains(item)) {
                res = res + calc.get(i).coast;
            }
        }
        return res;
    }
}
