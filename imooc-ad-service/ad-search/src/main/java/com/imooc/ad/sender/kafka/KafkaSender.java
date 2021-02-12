package com.imooc.ad.sender.kafka;

import com.alibaba.fastjson.JSON;
import com.imooc.ad.mysql.dto.MySqlRowData;
import com.imooc.ad.sender.ISender;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author Jiusen Guo
 * @date 2021/2/12 16:49
 */
@Component("kafkaSender")
public class KafkaSender implements ISender {

    @Value("${adconf.kafka.topic}")
    private String topic;

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sender(MySqlRowData rowData) {

        kafkaTemplate.send(
                topic, JSON.toJSONString(rowData)
        );
    }

    /**
     * kafka监听器
     * @param record
     */
    @KafkaListener(topics = {"ad-search-mysql-data"}, groupId = "ad-search")
    public void processMysqlRowData(ConsumerRecord<?, ?> record) {

        //监听消费者消费的记录
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            MySqlRowData rowData = JSON.parseObject(
                    message.toString(),
                    MySqlRowData.class
            );
            System.out.println("kafka processMysqlRowData: " +
                    JSON.toJSONString(rowData));
        }
    }
}
