package com.ityang.basic.controller;

import com.ityang.basic.service.KafkaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@Api("kafkaController")
public class KafkaController {
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);
    @Resource
    private KafkaService kafkaService;


    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;//kafkaTemplate相当于生产者

    /**
     * 生产Kafka
     *
     * @param topic
     * @param val
     * @return
     */
    @RequestMapping(value = "sendKafka", method = RequestMethod.GET)
    @ApiOperation(value = "写入缓存", notes = "写入Key,Val", response = String.class)
    public void sendKafka(@ApiParam("topic") @RequestParam("topic") String topic, @ApiParam("写入值") @RequestParam("val") String val) {
        try {
            kafkaService.producers(topic, val);
        } catch (Exception e) {
            logger.error(e + "");
        }
    }

    /**
     * 消费Kafka
     *
     * @param topic
     * @return
     */
    @RequestMapping(value = "getKafka", method = RequestMethod.GET)
    @ApiOperation(value = "写入缓存", notes = "写入Key,Val", response = String.class)
    public void getKafka(@ApiParam("topic") @RequestParam("topic") String topic) {
        try {
            kafkaService.consumer(topic);
        } catch (Exception e) {
            logger.error(e + "");
        }
    }


    @RequestMapping(value = "/{topic}/send", method = RequestMethod.GET)
    public void sendMeessage(
            @RequestParam(value = "message", defaultValue = "hello world") String message,
            @PathVariable final String topic) {
        logger.info("start sned message to {}", topic);
        ListenableFuture<SendResult<String, String>> listenableFuture = kafkaTemplate.send(topic, message);//发送消息，topic不存在将自动创建新的topic
        listenableFuture.addCallback(//添加成功发送消息的回调和失败的回调
                result -> logger.info("send message to {} success", topic),
                ex -> logger.info("send message to {} failure,error message:{}", topic, ex.getMessage()));
    }

    @RequestMapping(value = "/default/send", method = RequestMethod.GET)
    public void sendMeessagedefault() {//发送消息到默认的topic
        logger.info("start send message to default topic");
        kafkaTemplate.sendDefault("你好，世界");
    }

}
