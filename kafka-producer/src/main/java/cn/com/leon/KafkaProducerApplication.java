package cn.com.leon;

import cn.com.leon.producer.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangDi
 */
@SpringBootApplication
public class KafkaProducerApplication {

    public static ConfigurableApplicationContext ctx = null;

    public static void main(String[] args) {
        try {
            ctx = SpringApplication.run(KafkaProducerApplication.class);
            KafkaProducer kafkaProducer = (KafkaProducer) ctx.getBean("KafkaProducer");
            kafkaProducer.send();
            //启动阻塞线程
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
