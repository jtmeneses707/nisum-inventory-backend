package com.ascend.components.kafka;

import com.ascend.components.entities.Order;
import com.ascend.components.entities.OrderItems;
import com.ascend.components.services.ProductsService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
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
        String order_status = data.getOrder_status();

        for(OrderItems order_item: data.getOrderItems()){
            if("CREATE".equals(order_status)){
                service.reserveStock(order_item.getUpc(), order_item.getQuantity());
            }
            else if("SHIP".equals(order_status)){
                service.shipStock(order_item.getUpc(), order_item.getQuantity());
            }
            else if("CANCEL".equals(order_status)){
                service.cancelStock(order_item.getUpc(), order_item.getQuantity());
            }
            else{
                System.out.println("Some error");
            }
        }


    }
}
