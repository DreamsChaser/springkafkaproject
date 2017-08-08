package cn.com.leon.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * @author wangDi
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"topic1","topic2"})
    public void showContent(String content){
        System.out.println(content);
    }
}
