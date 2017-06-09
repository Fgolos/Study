package com.home.newProject;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by z003a0ns on 09.06.2017.
 */
public class UsersTest {
  @Test
  public void test1() {
    Users users = new Users();
    User user = new User(1, "name", "surname");
    users.addUser(user);

    assertEquals(1, users.users.size());
  }
}