package com.home.newProject;


import java.io.*;


/**
 * Created by FDR on 27.05.2017.
 */
public class Serial {
    String fileName;


    public Serial(String fileName) {
        this.fileName = fileName;
    }


    public void writeUserToFile(User user) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public serial.User retriveFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(this.fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        serial.User user = (serial.User) objectInputStream.readObject();
        return user;
    }
}

