package cn.com.leon.kafka;

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
        kafkaTemplate.send("topic1","topic1-data");
        kafkaTemplate.send("topic2","topic2-data");
        kafkaTemplate.metrics();
        kafkaTemplate.execute(new KafkaOperations.ProducerCallback() {
            @Override
            public Object doInKafka(Producer producer) {
                return null;
            }
        });
        //消息发送的监听器，用于回调遣返信息。
        kafkaTemplate.setProducerListener(new ProducerListener() {
            @Override
            public void onSuccess(String s, Integer integer, Object o, Object o2, RecordMetadata recordMetadata) {
                System.out.println("发送成功:"+s+"--"+integer+"--"+o+"--"+o2+"--"+recordMetadata+"");
            }

            @Override
            public void onError(String s, Integer integer, Object o, Object o2, Exception e) {
                System.out.println("发送失败:"+s+"--"+integer+"--"+o+"--"+o2+"--"+e.getMessage()+"");
            }

            @Override
            public boolean isInterestedInSuccess() {
                return false;
            }
        });
    }
}
