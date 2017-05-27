package serial;


import com.home.project.Serializer;

import java.io.*;

/**
 * Created by FDR on 22.05.2017.
 */
public class User implements Serializable {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User egorka = new User("Egorka", 25);
        Serializer serializer = new Serializer("test1.out");
        serializer.writeUserToFile(egorka);
        System.out.println(serializer.retriveFromFile());

    }


    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}

