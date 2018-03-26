package com.qs.sboot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.AbstractTemplateViewResolver;

@RestController
@SpringBootApplication  //组合注解，相当于@Configuration，@EnableAutoConfiguration，@ComponentScan

//注意：使用@SpringBootApplication注解默认会扫描当前类所在的包或子包，如果需要指定扫描的包可以使用@ComponentScan注解指定扫描包路径
@ComponentScan(basePackages = {"com.qs.sboot"})
@EnableCaching
public class SbootApplication {

	public static void main(String[] args) {
		//启动springBoot应用项目
		SpringApplication.run(SbootApplication.class, args);
	}

	@RequestMapping("/")
	public String index(){
		return "Hello SpringBoot";
	}


	/**
	 * @SuppressWarnings 注解上述注解是jse提供的注解。作用是屏蔽一些无关紧要的警告。
	 */
	@Bean
	@SuppressWarnings({"rawypes","unchecked"})
	public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.afterPropertiesSet();
		return redisTemplate;

	}

}
