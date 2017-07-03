package com.home.demo;

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


    public ArrayList<User> getUsers() {
        return users;
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
