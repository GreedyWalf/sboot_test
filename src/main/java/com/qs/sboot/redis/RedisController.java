package com.qs.sboot.redis;

import com.qs.sboot.jpatest.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping(value = "/set")
    public void set(){
        Person person = new Person(100L,"qyp", 25, "巢湖");
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    @RequestMapping(value = "/getString")
    public String getStr(){
        return personDao.getString();
    }

    @RequestMapping(value = "/getPerson")
    public Person getPerson(){
        return personDao.getPerson();
    }
}
