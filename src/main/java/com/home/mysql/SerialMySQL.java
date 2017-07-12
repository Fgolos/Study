package com.home.mysql;

import com.home.demo.Serial;
import com.home.demo.User;
import com.home.demo.Users;

import java.sql.*;

/**
 * Created by FDR on 04.07.2017.
 */
public class SerialMySQL implements SerialInterface {




    @Override
    public void writeUser(Users users) throws SQLException {
        String myUrl = "jdbc:mysql://localhost/test";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        Statement st = conn.createStatement();

        for (int i = 0; i < users.users.size(); i++) {
            String name = users.users.get(i).getName();
            String surname = users.users.get(i).getSurname();
            String addUser = "INSERT INTO `test`.`users` ( `first_name`, `last_name`) VALUES ('" + name + "', '" + surname + "');";
            st.executeQuery(addUser);

        }

    }

    @Override
    public Users loadUsers() throws SQLException {
        String myUrl = "jdbc:mysql://localhost/test";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        Statement st = conn.createStatement();
        String query = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(query);
        Users users = new Users();
        while (rs.next()) {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            User user = new User(id, firstName, lastName);
            users.addUser(user);
        }
        return users;
    }
}
