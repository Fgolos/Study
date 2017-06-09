package com.home.newProject.main.main;


import java.io.*;


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
        FileInputStream fileInputStream = new FileInputStream(this.fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Users users = (Users) objectInputStream.readObject();
        return users;
    }
}

