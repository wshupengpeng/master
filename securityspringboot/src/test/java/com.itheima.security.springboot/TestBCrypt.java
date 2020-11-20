package com.itheima.security.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class TestBCrypt {
    @Test
    public void testBCrypt(){
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);

        //校验
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$NO7yWt2b8JfsRaWpbQGW8.qBtORc1a.FI7NRB13Tr3Fi6LyMxLFPe");
        System.out.println(checkpw);
    }
}
