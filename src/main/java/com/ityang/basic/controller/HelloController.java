package com.ityang.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/7/21.
 */

@RestController
@Api(value = "HelloController")
public class HelloController {

    @RequestMapping("hello")
    public String Hello() {
        return "yang";
    }

    @RequestMapping("test2")
    public String Test() {
        return "test";
    }

    @RequestMapping("yang")
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    public String getSwagger(Integer id) {
        String sb1 = null;
        try {
            byte[] bytes = "你好".getBytes();//"UTF-16");
            System.out.println(bytes.toString());
            sb1 = new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(sb1);
        return sb1;
    }

    @RequestMapping("tes1t")
    public String test() {
        return "test";
    }
    @RequestMapping("test3")
    public String test4() {
        return "test";
    }
}
