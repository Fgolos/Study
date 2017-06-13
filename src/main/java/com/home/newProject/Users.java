package com.home.newProject;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by FDR on 07.06.2017.
 */
public class Users implements Serializable {
    public ArrayList<User> users;

    public Users() {
        users = new ArrayList<User>();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Users users = new Users();
        User user = new User(1, "vova", "putin");
        User user2 = new User(2, "vova2", "putin2");
        User user1 = new User(3, "Misha", "Keskenen");
        users.addUser(user1);
        users.addUser(user);
        users.addUser(user2);
        System.out.println(users);
        users.removeUserByID(35353);
        System.out.println(users);


        Serial serial = new Serial("test.out");
        serial.writeUserToFile(users);
        System.out.println(serial.retriveFromFile());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users1 = (Users) o;

        return users != null ? users.equals(users1.users) : users1.users == null;
    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Users{" + "users=" + users + '}';
    }


    public ArrayList<User> addUser(User user) {
        users.add(user);
        return users;
    }

    public void removeUserByID(Integer id) {
        for (int i = 0; i < users.size(); i++) {
            Integer id1 = users.get(i).id;
            if (id1 == id) {
                users.remove(users.get(i));


            }
        }
    }
}
