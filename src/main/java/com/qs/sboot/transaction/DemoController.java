package com.qs.sboot.transaction;

import com.qs.sboot.jpatest.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    /**
     * 测试有回滚的情况
     *
     * http://localhost:7788/sb/rollback.do?name=zhangsan&address=%E5%90%88%E8%82%A5%E5%B8%82&age=22
     */
    @RequestMapping(value = "/rollback")
    public Person rollBack(Person person) {
        return demoService.savePersonWithRollBack(person);
    }

    /**
     * 测试没有回滚的情况
     *
     * http://localhost:7788/sb/norollback.do?name=zhangsan&address=%E5%90%88%E8%82%A5%E5%B8%82&age=22
     */
    @RequestMapping(value = "/norollback")
    public Person noRollBack(Person person) {
        return demoService.savePersonWithoutRollBack(person);
    }

}
