package com.qs.sboot.controller.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component

//使用@ConfigurationProperties注解加载properties文件中的配置，通过prefix属性指定properties配置的前缀，通过location指定加载
//properties配置的路径；
@ConfigurationProperties(prefix = "author")
public class AuthorSetting {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AuthorSetting(){

    }

    public AuthorSetting(Integer age, String name){
        this.age = age;
        this.name = name;

    }
}
