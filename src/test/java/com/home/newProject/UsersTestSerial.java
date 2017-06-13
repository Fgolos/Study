package com.home.newProject;

import com.google.common.io.Files;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class UsersTestSerial {
  @Test
  public void test2()
  throws IOException, ClassNotFoundException {
    Users users = new Users();
    Serial serial = new Serial("test.out");
    serial.writeUserToFile(users);

    Users users1 = serial.retriveFromFile();
    assertEquals(users, users1);
  }

  @Test
  public void whenSerialTriesToReadFromNonExistFile_emptyListReturned_andFileCreated()
  throws Exception {
    //given
    final File tempDir = Files.createTempDir();
    final String unexistFileName = UUID.randomUUID().toString();
    final File file = new File(tempDir, unexistFileName);
    assertEquals(file.exists(), false);
    //when
    final Serial serial = new Serial(file.getAbsolutePath());
    final Users users = serial.retriveFromFile();
    //then
    assertEquals(users.users.size(), 0);
    assertEquals(file.exists(), true);
  }
}
