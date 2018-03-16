package com.qs.sboot.resttest;

import com.qs.sboot.jpatest.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * 定义实体类的Repository
 *
 * 访问下面的url：rest方式默认访问的为实体复数形式；（有时间深究）
 *  http://localhost:7788/sb/persons/
 *
 * @since 2018年03月11日21:03:01
 */
public interface PerRepository extends JpaRepository<Person, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name") String name);

    @RestResource(path = "all")
    List<Person> findAllByName(String name);
}
