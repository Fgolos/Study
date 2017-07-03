package com.home.demo;


import java.io.*;


/**
 * Created by FDR on 27.05.2017.
 */
public class Serial {
    String fileName;

    public Serial(String fileName) {
        this.fileName = fileName;
    }

    public void writeUserToFile(Users users) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(users);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public Users retriveFromFile() {
        try {
            File file = new File(fileName);
            boolean exists = file.exists();
            if (exists == true) {
                FileInputStream fileInputStream = new FileInputStream(this.fileName);
                Users users;
                try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                    users = (Users) objectInputStream.readObject();
                }
                return users;
            } else {
                File file1 = new File(fileName);
                file1.createNewFile();
                Users users = new Users();
                writeUserToFile(users);
                return users;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
