package com.home.newProject;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by FDR on 09.06.2017.
 */
public class UsersTestSerial {
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        Users users = new Users();
        Serial serial = new Serial("test.out");
        serial.writeUserToFile(users);

        Users users1 = serial.retriveFromFile();
        assertEquals(users, users1);

    }
}
