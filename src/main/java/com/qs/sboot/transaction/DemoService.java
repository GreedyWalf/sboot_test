package com.qs.sboot.transaction;

import com.qs.sboot.jpatest.Person;

public interface DemoService {

    Person savePersonWithRollBack(Person person);

    Person savePersonWithoutRollBack(Person person);

    Person findOne(Person person);

    void remove(Long personId);

    Person save(Person person);
}
