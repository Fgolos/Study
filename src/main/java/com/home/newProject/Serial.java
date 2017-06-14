package com.home.newProject;


import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;


/**
 * Created by FDR on 27.05.2017.
 */
public class Serial {
    String fileName;


    public Serial(String fileName) {
        this.fileName = fileName;

    }


    public void writeUserToFile(Users users) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(users);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public Users retriveFromFile() throws IOException, ClassNotFoundException {
        File file = new File("C:\\projects\\Study" + fileName);
        boolean exists = file.exists();
        if (exists == true) {
            FileInputStream fileInputStream = new FileInputStream(this.fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Users users = (Users) objectInputStream.readObject();
            return users;
        } else {
            File file1 = new File("C:\\projects\\Study" + fileName);
            file1.createNewFile();
            Users users = new Users();
            writeUserToFile(users);
            return users;
        }

    }
}

