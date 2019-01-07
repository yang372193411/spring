package com.ityang.basic.controller;

import com.ityang.basic.entity.User;
import com.ityang.basic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户注册功能
 */
@RestController
@Api(description = "用户注册Controller")
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);


    @Autowired
    /**
     * 用户管理类
     */
    private UserService userService;


    /**
     * 判断是否已注册功能
     */
    @RequestMapping(value = "checkIsRegister", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "判断是否已注册功能", notes = "判断是否已注册功能", response = String.class)
    public Map<String, String> checkIsRegister(String userName) {
        Map<String, String> msgMap = new HashMap<String, String>();
        Pattern pattern = Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
        Matcher matcher = pattern.matcher(userName);
        boolean isRegister = false;
        User user = null;
        //如果是手机号则根据手机号查询
        if (matcher.matches()) {
            user = userService.getUserByPhone(userName);
        }//否则就全都根据用户名查询账户
        else {
            user = userService.getUserByUserName(userName);
        }
        if (null != user) {
            isRegister = true;
            msgMap.put("isOk", isRegister + "");
            msgMap.put("msg", "用户:" + user.getUsername() + "已经注册");
        } else {
            msgMap.put("isOk", isRegister + "");
            msgMap.put("msg", "用户或手机:" + userName + "可以注册");
        }
        return msgMap;
    }


    /**
     * 判断是否已注册功能
     */
    @RequestMapping(value = "registerUser", method = {RequestMethod.POST})
    @ApiOperation(value = "判断是否已注册功能", notes = "判断是否已注册功能", response = String.class)
    public Map<String, String> registerUser(@RequestBody User user) {
        Map<String, String> msgMap = new HashMap<String, String>();
        int returnInt = userService.saveUser(user);
        if (returnInt > 0) {
            msgMap.put("isOk", "true");
            msgMap.put("msg", "注册成功");
        } else {
            msgMap.put("isOk", "false");
            msgMap.put("msg", "注册失败");
        }
        return msgMap;
    }
}
