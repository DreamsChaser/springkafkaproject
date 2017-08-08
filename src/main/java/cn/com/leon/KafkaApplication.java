package cn.com.leon;

import cn.com.leon.kafka.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wangDi on 2017/8/8.
 */
@SpringBootApplication
public class KafkaApplication {

    public static ConfigurableApplicationContext ctx = null;

    public static void main(String[] args) {
        try {
            ctx = SpringApplication.run(KafkaApplication.class);
            //启动阻塞线程
            KafkaProducer kafkaProducer = (KafkaProducer) ctx.getBean("KafkaProducer");
            kafkaProducer.send();
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
