package com.home.mysql;

import com.home.demo.Users;

import java.sql.SQLException;

/**
 * Created by FDR on 04.07.2017.
 */
public interface SerialInterface {
    void writeUser(Users users) throws SQLException;

    Users loadUsers() throws SQLException;


}
