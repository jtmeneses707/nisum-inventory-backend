package com.ascend.components.kafka;

import com.ascend.components.entities.Order;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

@Service
public class KafkaConsumer {

//    @KafkaListener(
//            topics = "oms-order-create",
//            groupId = "group_id"
//    )
//    public void consume(String message){
//        System.out.println("Consumed message: " + message);
//    }


    @KafkaListener(
            topics = {"oms-order-create",
                    "wms-order-shipped",
                    "oms-order-canceled"},
            groupId = "group_json",
            properties = {"enable.auto.commit:false", ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG + ":${spring.kafka.bootstrap-servers}"},
            containerFactory = "orderKafkaListenerFactory"
    )
    public void consumeJson(@Payload Order data) throws InterruptedException {
        //manipulate the data within here
        System.out.println(data);
        if("CREATE".equals(data.getStatus())){
            System.out.println("CREATE SOMETHING");

        }
        else if("SHIP".equals(data.getStatus())){
            //some function
        }
        else{
            //order status = CANCEL
            //some function
            System.out.println("CANCEL SOMETHING");
        }
    }
}
