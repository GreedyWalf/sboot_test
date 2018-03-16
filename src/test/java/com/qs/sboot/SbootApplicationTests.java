package com.qs.sboot;

import com.qs.sboot.jpatest.Person;
import com.qs.sboot.jpatest.PersonRepository;
import com.qs.sboot.transaction.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbootApplicationTests {

	@Resource
	private PersonRepository personRepository;

	@Test
	public void testFindOne() {
		Person person = personRepository.findOne(1L);

	}

}
