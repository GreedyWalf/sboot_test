package com.qs.sboot.jpatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;

    @ResponseBody
    @RequestMapping(value = "/delete")
    public String testDelete(Long id){
        personRepository.delete(id);
        return "delete data success";
    }

    @RequestMapping(value = "/save")
    public Person save(Person person) {
        Person per = personRepository.save(person);
        return per;
    }

    @RequestMapping(value = "/query1")
    public List<Person> getPersonList(String address) {
        List<Person> personList = personRepository.findByAddress(address);
        return personList;
    }

    @RequestMapping(value = "/query2")
    public Person getPerson(String name, String address) {
        Person person = personRepository.findByNameAndAddress(name, address);
        return person;
    }

    @RequestMapping(value = "/query3")
    public Person getPerson2(String name, String address) {
        return personRepository.withNameAndAddressQuery(name, address);
    }

    @RequestMapping(value = "/query4")
    public Person getPerson3(String name, String address) {
        return personRepository.withNameAndAddressNamedQuery(name, address);
    }

    @RequestMapping(value = "/sort")
    public List<Person> sort(){
        List<Person> personList = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return personList;
    }


    /**
     * jpa支持的分页测试
     *
     * @param pageNo 页数（第几页）
     * @param pageSize 页容量（每页包含多少数据）
     * @return Person实体分页数据
     */
    @RequestMapping(value = "/page")
    public Page<Person> page(int pageNo, int pageSize){
        Page<Person> all = personRepository.findAll(new PageRequest(pageNo, pageSize));
        return all;
    }

    @RequestMapping(value = "/all")
    public List<Person> all(){
        return personRepository.findAll();
    }

}
