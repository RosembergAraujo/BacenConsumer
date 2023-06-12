package com.ibm.bacenconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ibm.bacenconsumer.Annotations.Generated;

@SpringBootApplication
@EnableFeignClients
@Generated
public class BacenConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BacenConsumerApplication.class, args);
    }

}
