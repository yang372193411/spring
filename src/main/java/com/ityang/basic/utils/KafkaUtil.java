package com.ityang.basic.utils;



import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.security.JaasUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KafkaUtil {
    private static final Lock lock = new ReentrantLock();
    private static final Logger logger = LoggerFactory.getLogger(KafkaUtil.class);
    private static String kafkaHosts = "elsearch:9092";
    private static String zkHosts = "127.0.0.1:2181";

    public static KafkaProducer<String, String> createProducer() {
        KafkaProducer<String, String> producer = null;
        try {
            lock.lock();
            Properties properties = new Properties();
            properties.put("bootstrap.servers", kafkaHosts);
            properties.put("acks", "all");
            properties.put("retries", 0);
            properties.put("batch.size", 16384);
            properties.put("linger.ms", 1);
            properties.put("buffer.memory", 33554432);
            properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            producer = new KafkaProducer<String, String>(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return producer;
    }

    public static void send(String topic, String value) {

        try {
            if (checkTopic(topic)) {
                createTopic(topic);
            }
            createProducer().send(new ProducerRecord<String, String>(topic, createRowKey(""), value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static KafkaConsumer createConsumer() {
        KafkaConsumer<String, String> consumer = null;

        try {
            lock.lock();
            Properties properties = new Properties();
            properties.put("bootstrap.servers", kafkaHosts);
            properties.put("group.id", "181");
            properties.put("enable.auto.commit", "true");
            properties.put("auto.commit.interval.ms", "1000");
            properties.put("auto.offset.reset", "earliest");
            properties.put("session.timeout.ms", "30000");
            properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
            consumer = new KafkaConsumer<String, String>(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return consumer;
    }

    public static String createRowKey(String key) {
        if (StringUtils.isEmpty(key)) {
            return encrypt(UUID.randomUUID().toString().replace("-", "")).substring(0, 4) + "_" + key;
        } else {
            return encrypt(key);
        }
    }

    public static String encrypt(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            BigInteger hash = new BigInteger(1, md.digest());
            return hash.toString(16);
        } catch (Exception e) {
            logger.error(e + "");
            return null;
        }
    }

    /**
     * 创建topic
     *
     * @param topic
     * @throws Exception
     */
    public static void createTopic(String topic) throws Exception {
        ZkUtils zkUtils = null;
        try {
            zkUtils = getZkUtils();
            AdminUtils.createTopic(zkUtils, topic, 1, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != zkUtils) {
                zkUtils.close();
            }
        }
    }

    /**
     * 删除topic
     *
     * @param topic
     * @throws Exception
     */
    public static void deleteTopic(String topic) throws Exception {
        ZkUtils zkUtils = null;
        try {
            zkUtils = getZkUtils();
            AdminUtils.deleteTopic(zkUtils, topic);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != zkUtils) {
                zkUtils.close();
            }
        }
    }

    private static ZkUtils getZkUtils() {
        return ZkUtils.apply(zkHosts, 30000, 30000, JaasUtils.isZkSecurityEnabled());
    }

    /**
     * 查询Topic
     *
     * @param topic
     * @return
     * @throws Exception
     */
    public static Map queryTopic(String topic) throws Exception {
        Map map = null;
        ZkUtils zkUtils = null;
        try {
            zkUtils = getZkUtils();
            // 获取topic 'test'的topic属性属性
            Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), topic);
            // 查询topic-level属性
            Iterator it = props.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + " = " + value);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != zkUtils) {
                zkUtils.close();
            }
            return map;
        }
    }

    /**
     * 查询Topic是不存在
     *
     * @param topic
     * @return
     * @throws Exception
     */
    public static boolean checkTopic(String topic) throws Exception {
        boolean isHasTopic = false;
        ZkUtils zkUtils = null;
        try {
            zkUtils = getZkUtils();
            if (AdminUtils.topicExists(zkUtils, topic)) {
                isHasTopic = true;
            }
        } catch (Exception e) {

            throw e;
        } finally {
            if (null != zkUtils) {
                zkUtils.close();
            }
            return isHasTopic;
        }
    }

    /**
     * 修改topic
     *
     * @return
     * @throws Exception
     */
    public static void updateTopic(String newTopic, String oldTopic) throws Exception {
        ZkUtils zkUtils = null;
        try {
            zkUtils = getZkUtils();
            Properties props = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(), newTopic);
            // 增加topic级别属性
            props.put("min.cleanable.dirty.ratio", "0.3");
            // 删除topic级别属性
            props.remove("max.message.bytes");
            // 修改topic 'test'的属性
            AdminUtils.changeTopicConfig(zkUtils, oldTopic, props);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != zkUtils) {
                zkUtils.close();
            }
        }
    }
}
