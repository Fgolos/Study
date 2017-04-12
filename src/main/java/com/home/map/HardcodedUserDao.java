package com.home.map;

/**
 * Created by FDR on 11.04.2017.
 */
public class HardcodedUserDao implements UserDao {

    @Override
    public User showInfo(int id) {
        User user = new User(1, "Vova", "Putin");
        return user;
    }
}
