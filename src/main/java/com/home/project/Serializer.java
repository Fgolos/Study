package com.home.project;

import serial.*;

import java.io.*;

/**
 * Created by FDR on 22.05.2017.
 */
public class Serializer {
    String fileName;

    public Serializer(String fileName) {
        this.fileName = fileName;
    }


    public void writeUserToFile(serial.User user) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.fileName);
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
