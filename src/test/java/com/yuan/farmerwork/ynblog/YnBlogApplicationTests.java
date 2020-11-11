package com.yuan.farmerwork.ynblog;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

//@SpringBootTest
class YnBlogApplicationTests {

   // @Test
    //void contextLoads() {
   // }

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(1, 3, 4);
        Object[] objects = values.toArray();
        System.out.println(objects.getClass().getSimpleName());
        //objects[0] = new Object();
    }

}
