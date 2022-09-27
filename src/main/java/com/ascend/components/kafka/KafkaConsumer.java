package com.ascend.components.kafka;

import com.ascend.components.entities.Order;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {
    @KafkaListener(
            topics = {"oms-order-create",
                    "wms-order-shipped",
                    "oms-order-canceled"},
            groupId = "group_json",
            containerFactory = "orderKafkaListenerFactory"
    )
    public void consumeJson(Order data){
        //manipulate the data within here
        System.out.println(data);

        if(data.getStatus() == "CREATE"){
            //some function

        }
        else if(data.getStatus() == "SHIP"){
            //some function
        }
        else{
            //order status = CANCEL
            //some function
        }
    }
}
