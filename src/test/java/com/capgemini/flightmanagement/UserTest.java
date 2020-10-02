package com.capgemini.flightmanagement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.flightmanagement.dao.UserDao;
import com.capgemini.flightmanagement.entity.User;
import com.capgemini.flightmanagement.service.UserService;

@SpringBootTest
public class UserTest {
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserDao dao;
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUserName("tarun");
		user.setPhone(123456789l);
		user.setEmail("someone@example.com");
		user.setPassword("12345678");
		when(dao.save(user)).thenReturn(user);
		assertEquals(user, userService.addUser(user));
	}
		
}
