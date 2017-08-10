package cn.com.leon.producer;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.stereotype.Component;

/**
 * 消息产生者
 * @author wangDi
 */
@Component("KafkaProducer")
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(){
        kafkaTemplate.send("test","test1");
    }
}
