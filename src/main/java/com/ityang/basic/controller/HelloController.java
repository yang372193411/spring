package com.ityang.basic.controller;

import com.ityang.basic.entity.User;
import com.ityang.basic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2018/7/21.
 */

@RestController
//@Api(value = "HelloController")
@Api(description ="Hello控制器")
public class HelloController {

    @Resource
    private UserService service;

    @RequestMapping(value = "user",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    public User getUserById(Integer id){
        return service.getUserId(id);
    }

}
