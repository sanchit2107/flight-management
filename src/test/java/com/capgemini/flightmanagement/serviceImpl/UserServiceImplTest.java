package com.capgemini.flightmanagement.serviceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.utils.UserJwtUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class UserServiceImplTest {
	
	@Autowired
	UserServiceImpl service;
	
	@Autowired
	TestEntityManager entitymanager;
	
	@MockBean
	UserJwtUtil jwt;
	
	private User getUser() {
		User user = new User(123, "tarun", "baguvixt", 8400019457l, "abc@gmail.com");
		return user;
	}
	
	@Test
	void testAddUser() {
		User savedUser = getUser();
		service.addUser(savedUser);
		User emUser = entitymanager.find(User.class, savedUser.getUserId());
		assertThat(savedUser).isEqualToComparingFieldByField(emUser);
	}

}
