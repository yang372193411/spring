package com.ityang.basic.service.impl;

import com.ityang.basic.controller.KafkaController;
import com.ityang.basic.service.KafkaService;
import com.ityang.basic.utils.KafkaUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Map;

@Service("kafkaService")
public class KafkaServiceImpl implements KafkaService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaController.class);



    @Override
    public Map consumer(String topic) {

        KafkaConsumer consumer = KafkaUtil.createConsumer();
        consumer.subscribe(Arrays.asList(topic));
        ConsumerRecords<String, String> records=consumer.poll(1000);
        for (ConsumerRecord<String,String> record:records) {
            logger.info(record.value());
        }
        return null;

    }

    @Override
    public void producers(String topic, Object data) {

        KafkaUtil.send(topic, data.toString());
    }


}
