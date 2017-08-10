package cn.com.leon.cosumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 * @author wangDi
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"test"})
    public void showContent(String content){
        System.out.println(content);
    }
}
