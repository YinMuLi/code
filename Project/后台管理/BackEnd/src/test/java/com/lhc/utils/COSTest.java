package com.lhc.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class COSTest {

    @Autowired
    private COS cos;

    @Test
    public void token() {
        System.out.println(cos.getAvatarKey());
    }
}