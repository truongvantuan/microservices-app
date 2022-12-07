package com.company.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * @author truongtuan
 */
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);

        int a = 5;
        List<Integer> list = new ArrayList<>();
        list.add(a);

        List list1 = new ArrayList<>();
        list1.add("string");
        list1.add(5);
    }
}
