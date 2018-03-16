package com.qs.sboot.transaction;

import com.qs.sboot.jpatest.Person;
import com.qs.sboot.jpatest.PersonRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person per = personRepository.save(person);
        if (person.getName().equals("zhangsan")) {
            throw new IllegalArgumentException("zhangsan已经存在，数据库将要回滚啦！！");
        }

        return per;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        return personRepository.save(person);
    }

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person){
        Person per = personRepository.save(person);
        System.out.println("为id、key为：" + per.getId() + "数据做了缓存!");
        return per;
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person per = personRepository.findOne(person.getId());
        System.out.println("为id、key为：" + per.getId() + "数据缓存！");
        return per;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id){
        System.out.println("删除了id、key为：" + id + "的数据缓存！");
        personRepository.delete(id);
    }
}
