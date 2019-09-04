package com.ityang.basic.controller;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/test")
@Api("测试类")
@Log4j
public class TestController {
    int[] ints = {1,2,3,4};

    @GetMapping("/test1")
    public void getTest1(){

        List list = null;
        try {
            list = Arrays.asList(this.ints);
            list.add(5);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @GetMapping("/test2")
    public void getTest2(){
        List list = new ArrayList(Arrays.asList(this.ints));
        list.add(5);
    }


}
