package com.ityang.basic.controller;

import com.ityang.basic.config.PropertiesConfig;
import com.ityang.basic.entity.User;
import com.ityang.basic.mapper.UserMapper;
import com.ityang.basic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2018/7/21.
 */

@RestController
@Api(description = "helloController")
@Slf4j
public class HelloController {


    @Value("${spring.redis.host}")
    private String redisIp;
    @Resource
    private UserService service;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @RequestMapping(value = "user", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "query")
    public User getUserById(Integer id) {
        return service.getUserById(id.toString());
    }

    /**
     * @param reg ^(\d{4})-(\d{2})-(\d{2})$
     * @param val 2018-10-12
     * @param rel $1-$2-$3-00
     * @return 执行正则表达式, 规则值为^(\d{4})-(\d{2})-(\d{2})$,执行前的值为2018-10-12,执行后的值为2018-10-12-00
     */
    @RequestMapping(value = "regex", method = {RequestMethod.GET})
    @ApiOperation(value = "使用正则表达式", notes = "使用正则表达式")
    public String regex(@ApiParam(name = "reg", value = "正则表达式") @RequestParam("reg") String reg,
                        @ApiParam(name = "val", value = "内容") @RequestParam("val") String val,
                        @ApiParam(name = "rel", value = "替换正则") @RequestParam("rel") String rel) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(val);
        System.out.println(matcher.matches());
        String result = matcher.replaceAll(rel);
        return ("执行正则表达式,规则值为" + reg
                + ",执行前的值为" + val + ",执行后的值为" + result);
    }

    @RequestMapping(value = "hello",method = {RequestMethod.GET})
    @ApiOperation(value = "获取IP", notes = "获取IP")
    public String getStr() {
        log.info(redisIp);
        return redisIp;
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ApiOperation(value = "test", notes = "test")
    public String test(){
        String dbType = PropertiesConfig.getDbType();
        log.info(dbType);
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.getId();

        return String.valueOf(service.test());
    }

}
