package com.rookie.bigdata;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();

        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }
}
