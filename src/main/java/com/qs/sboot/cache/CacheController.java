package com.qs.sboot.cache;

import com.qs.sboot.jpatest.Person;
import com.qs.sboot.transaction.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CacheController {

    @Resource
    private DemoService demoService;

    /**
     * springBoot默认ConcurrentMapCacheManager作为缓存技术
     *
     * 测试保存数据，并缓存数据（之后查询，会先根据person.id在缓存中获取）
     */
    @RequestMapping(value = "/put")
    public Person put(Person person) {
        return demoService.save(person);
    }

    /**
     * 测试查询数据，并缓存数据
     */
    @RequestMapping(value = "/able")
    public Person cacheable(Person person) {
        return demoService.findOne(person);
    }

    /**
     * 测试删除数据，并清除缓存数据
     */
    @RequestMapping(value = "/evit")
    public String evit(Long id) {
        demoService.remove(id);
        return "ok";
    }

}
