package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.home.web.Time;
import org.omg.CORBA.Object;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeString.search;


/**
 * Created by FDR on 15.03.2017.
 */
public class Runner {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Time time = new Time(5l);
        String string = objectMapper.writeValueAsString(time);
        System.out.println(string);

    }
}

//    public static ArrayList<File> search(String path, String filename) {
//        File[] convertBytesToFile = new File(path).listFiles();
//        ArrayList<File> result = new ArrayList();
//        for (File file1 : convertBytesToFile) {
//            if (file1.getName().contains(filename)) {
//                result.add(file1);
//            }
//        }
//        return result;
//    }







