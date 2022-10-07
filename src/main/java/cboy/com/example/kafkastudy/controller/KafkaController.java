package cboy.com.example.kafkastudy.controller;

import cboy.com.example.kafkastudy.config.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author cboy.yang
 * @createDate 2022-10-06 21:54
 */
@Configuration
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Resource
    private KafkaTemplate kafkaTemplate;

    @Resource
    private ConsumerConfig config;

    /**
     * 发送kafka消息
     *
     * @return
     */
    @GetMapping("/send")
    public String send(@RequestParam("topic") String topic, @RequestParam("data") String data) {
        System.out.println(topic + " " + data);
        var result = kafkaTemplate.send(topic,"ab",data);
        return result.toString();
    }

    @GetMapping("/consumer")
    public String consumer() throws InterruptedException {
        System.out.println("异步任务执行中");
        config.consumer();
        System.out.println("异步任务已开启");
        return "success";
    }
}
