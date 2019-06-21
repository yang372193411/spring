package com.ityang.basic;

import org.junit.Test;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class AutoClass {
    static  int i =0;

    @Test
    public synchronized void AutoCreate() {
        for(; i <10; i ++){

            new Thread(

                    () -> {

                System.out.println("Hello World"+i);
                System.out.println( i+"---->"+Thread.currentThread().getName());

            }).start();
        }

    }

}
