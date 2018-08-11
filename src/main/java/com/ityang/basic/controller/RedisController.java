package com.ityang.basic.controller;

import com.ityang.basic.entity.User;
import com.ityang.basic.service.RedisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(description = "redis控制器")
public class RedisController {
    @Resource
    private RedisService redisService;

    /**
     * 设置Str缓存
     *
     * @param key
     * @param val
     * @return
     */
    @RequestMapping(value = "setStr",method = RequestMethod.GET)
    @ApiOperation(value = "写入缓存", notes = "写入Key,Val",response = String.class)
    public String setStr(@ApiParam("redis Key") @RequestParam("key") String key, @ApiParam("写入值")@RequestParam("val")String val) {
        try {
            redisService.setStr(key, val);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 根据key查询Str缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "getStr",method = RequestMethod.GET)
    @ApiOperation(value = "获取缓存", notes = "根据Key获取Rdis的Val",response = String.class)
    public String getStr(String key) {
        return redisService.getStr(key);
    }


    /**
     * 根据key产出Str缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "delStr",method = RequestMethod.GET)
    @ApiOperation(value = "删除缓存",notes ="根据key删除Str缓存" ,response = String.class)
    public String delStr(@ApiParam("redisKey") String key) {
        try {
            redisService.del(key);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }


    /**
     * 设置obj缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "setObj",method = RequestMethod.GET)
    @ApiOperation(value = "设置obj缓存",notes = "通过Key设置obj缓存",response = String.class)
    public String setObj(@ApiParam("redis Key") String key//, @ApiParam("要写入的User对象") User user
    ) {
        try {
            User user = new User();
            user.setId(5);
            user.setMoble("15111675879");
            user.setName("yang");
            user.setPass("123456");
            redisService.setObj(key, user);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 获取obj缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "getObj",method = RequestMethod.GET)
    @ApiOperation(value = "获取obj缓存",notes = "通过Key获取obj缓存",response = String.class)
    public Object getObj(@ApiParam("redisKey") String key) {
        return redisService.getObj(key);
    }


    /**
     * 删除obj缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "delObj",method = RequestMethod.GET)
    @ApiOperation(value = "删除obj缓存",notes = "通过Key删除Redis中的Obj缓存",response = Object.class)
    public Object delObj(@ApiParam("Redis Key") String key) {
        try {
            redisService.delObj(key);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
