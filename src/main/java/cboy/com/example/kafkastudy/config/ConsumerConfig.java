package cboy.com.example.kafkastudy.config;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

/**
 * @author cboy.yang
 * @createDate 2022-10-07 18:48
 */
@Configuration
public class ConsumerConfig {
    private static final String BORKERLIST = "kokocboy.top:9092";
    private static final String TOPIC = "cboy";
    private static final String GROUID = "group.demo312";

    @Async
    public void consumer() throws InterruptedException {
        System.out.println("开始----kafaka监听");
        Properties p = new Properties();
        /**
         * 测试 属性
         */
        //从最早的消息获取
        p.put("auto.offset.reset", "earliest");


        //----------------
        //分组ID
        p.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, GROUID);
        //broker集群
        p.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BORKERLIST);
        //key序列化
        p.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //value序列化
        p.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        //创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer(p);
        //订阅主题
        consumer.subscribe(List.of(TOPIC));
        while (true) {
            System.out.println("sleep 5s");
            Thread.sleep(5000);
            //从服务端拉取数据
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(3000));
            for (var record : records) {
                System.out.println("消费消息 value=" + record.value()
                        + " topic=" + record.topic()
                        + " key=" + record.key()
                        + " par="+record.partition());
            }
        }
    }

}
