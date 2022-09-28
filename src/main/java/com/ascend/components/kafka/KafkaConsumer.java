package com.ascend.components.kafka;

import com.ascend.components.entities.Order;
import com.ascend.components.services.ProductsService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumer {

    @Autowired
    ProductsService service;

    @KafkaListener(
            topics = {"oms-order-create",
                    "wms-order-shipped",
                    "oms-order-canceled"},
            groupId = "group_json",
            properties = {"enable.auto.commit:false", ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG + ":${spring.kafka.bootstrap-servers}"},
            containerFactory = "orderKafkaListenerFactory")
    public void consumeJson(@Payload Order data) throws InterruptedException {
        //manipulate the data within here
        System.out.println(data);
        if("CREATE".equals(data.getStatus())){
            service.reserveStock(data.getUPC(), data.getQuantity());
        }
        else if("SHIP".equals(data.getStatus())){
            service.shipStock(data.getUPC(), data.getQuantity());
        }
        else if("CANCEL".equals(data.getStatus())){
            service.cancelStock(data.getUPC(), data.getQuantity());
        }
        else{
            System.out.println("Some error");
        }
    }
}
