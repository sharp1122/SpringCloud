package com.dachen.compute;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dachen.compute.domain.User;
import com.dachen.compute.repository.UserMapper;
import com.dachen.compute.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ComputeApp.class)
public class UserTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
	@Before
	public void setUp() {
		userRepository.deleteAll();
	}
	@Test
	public void test() throws Exception {
		// MongoDB...
		// 创建三个User，并验证User总数
		userRepository.save(new User(1L, "didi", 30));
		userRepository.save(new User(2L, "mama", 40));
		userRepository.save(new User(3L, "kaka", 50));
		System.out.println("++++++++++++++++++++++++++");
		Assert.assertEquals(3, userRepository.findAll().size());
		// 删除一个User，再验证User总数
		User u = userRepository.findOne(1L);
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());
		// 删除一个User，再验证User总数
		u = userRepository.findByName("mama");
		userRepository.delete(u);
		Assert.assertEquals(1, userRepository.findAll().size());
		
		// Redis...
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
		
		// MySQL...
		userMapper.insert("AAA", 20);
		User user = userMapper.findByName("AAA");
		Assert.assertEquals(20, user.getAge().intValue());
	}
}
