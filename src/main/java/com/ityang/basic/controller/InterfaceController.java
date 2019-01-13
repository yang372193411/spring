package com.ityang.basic.controller;


import com.ityang.basic.utils.Code;
import com.ityang.basic.utils.Constants;
import com.ityang.basic.utils.ServiceException;
import com.ityang.basic.utils.StringTool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 */
@RestController
@Api("接口服务")
public class InterfaceController {
    private static final Logger logger = LoggerFactory.getLogger(InterfaceController.class);
    private int callvisit = 0;

    @RequestMapping(value = "getLog", method = {RequestMethod.GET})
    @ApiOperation(value = "生产调用接口服务日志信息", notes = "获取IP")
    public void getStr() {
        callvisit++;

        // 根据消费者发送的服务编码查询出的鉴权信息
        try {
            // 存储调用日志，准备监控的数据
            MDC.put(Constants.IP, "127.0.0.1");
            String currentTime = StringTool.getCurrentTime();
            MDC.put(Constants.STARTTIME, currentTime);
            currentTime = currentTime.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "");
            MDC.put(Constants.CALLTIME, currentTime);
            MDC.put(Constants.PARAM, "{\"doCount\":true,\"endRow\":100,\"fields\":\"*\",\"fulllogic\":\"and\",\"fullopt\":\"like\",\"onlyCount\":false,\"pageNum\":1,\"pageSize\":100,\"startRow\":1,\"syntaxCheck\":true,\"token\":\"502174#935735d255c1b2a968#3d0afd37\",\"transcoding\":\"false\"}");
            // 根据消费者传入的TOKEN查出的接入方ID
            MDC.put(Constants.TOKEN_CONSUMER_ID, "C00-10000016");
            // 消费者传入的消费码
//			MDC.put(Constants.CONSUMER_CODE, vConsumerCode);
            // 消费者传入的TOKEN查出的接入方部门
            MDC.put(Constants.DEPTCODE, "320000000000_0");
            // 生产者传入的服务主键
            MDC.put(Constants.SERVICEPID, "e9ad5766-f23b-4294-b006-d821a13a25dd");
            MDC.put(Constants.SERVICESIGN, "2907027c5f3958f6");
            MDC.put(Constants.SERVICECODE, "S00-00000003");
            MDC.put(Constants.APPPID, "C00-10000016");
            // 允许访问次数
            MDC.put(Constants.ALLOW_VISIT, "2222");
            // 第几次访问
            MDC.put(Constants.CUR_VISIT, callvisit + "");
            MDC.put(Constants.CALLSTATUS, Constants.NumberConsStr.ZERO);
            MDC.put(Constants.STACKINFO, Constants.NumberConsStr.ZERO);
            MDC.put(Constants.RESTEXCEPTIONCODE, Constants.NumberConsStr.ZERO);
            MDC.put(Constants.RESTEXCEPTIONINFO, Constants.NumberConsStr.ZERO);
        } catch (Exception e) {
            throw new ServiceException(Code.ERROR.getCode(), Code.ERROR.getDescribe());
        } finally {
            logger.info("接口调用完成");
            MDC.clear();
        }
    }


    @RequestMapping(value = "getInterface", method = {RequestMethod.GET})
    @ApiOperation(value = "获取getInterface接口服务信息", notes = "获取IP")
    public void getInterface() {

    }

}
