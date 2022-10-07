package cboy.com.example.kafkastudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author cboy.yang
 */
@SpringBootApplication
@EnableAsync
public class KafkaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaStudyApplication.class, args);
    }

}
