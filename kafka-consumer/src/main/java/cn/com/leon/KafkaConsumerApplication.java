package cn.com.leon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangDi
 */
@SpringBootApplication
public class KafkaConsumerApplication {

    public static ConfigurableApplicationContext ctx = null;

    public static void main(String[] args) {
        try {
            ctx = SpringApplication.run(KafkaConsumerApplication.class);
            //启动阻塞线程
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
