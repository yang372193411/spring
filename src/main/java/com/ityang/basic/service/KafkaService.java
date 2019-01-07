package com.ityang.basic.service;

import java.util.Map;

/**
 * kafka
 */
public interface KafkaService {

    /**
     * 消费Kafka
     * @param topic
     * @return
     */
    public Map consumer(String topic);
    /**
     * 生产Kafka
     * @param topic
     * @return
     */
    public void producers(String topic,Object data);
}
