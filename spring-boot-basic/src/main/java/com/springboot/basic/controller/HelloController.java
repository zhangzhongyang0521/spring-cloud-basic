package com.springboot.basic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/index")
    public String index() {
        return "spring boot hello~";
    }

    @Value("${book.name}")
    private String bookName;
    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.desc}")
    private String bookDesc;
    @Value("#{100.5}")
    private float price;

    @GetMapping("/book")
    public String getBook() {
        return String.format("book{name:%s,author:%s,price:%s,bookDesc:%s}", bookName, bookAuthor, price, bookDesc);
    }

    @Value("${com.springcloud.value}")
    private String randomValue;
    @Value("${com.springcloud.int}")
    private int randomInt;
    @Value("${com.springcloud.long}")
    private long randomLong;
    @Value("${com.springcloud.num1}")
    private int randomNum1;
    @Value("${com.springcloud.num2}")
    private int randomNum2;

    @GetMapping("/random")
    public String getRandom() {
        return String.format("value:%s,int:%s,long:%s,num1:%s,num2:%s",
                randomValue, randomInt, randomLong, randomNum1, randomNum2);
    }

}
