package com.online_ordering.presentation;

import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.user.User;
import com.online_ordering.user.UserService;
import com.online_ordering.user.abstractions.IUserRepository;
import com.online_ordering.utilities.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class UserServiceTests {
	@Test
	public void GetAllUsers_returns_all_users() {

		IUserRepository userRepository = Mockito.mock(IUserRepository.class);
		IOrderRepository order = Mockito.mock(IOrderRepository.class);

		List<User> users = new ArrayList<>();

		User ismael = new User();
		ismael.setId(1);
		ismael.setEmail("if");
		ismael.setOrderExisting(false);

		User danielle = new User();
		ismael.setId(2);
		ismael.setEmail("dj");
		ismael.setOrderExisting(true);

		User scott = new User();
		ismael.setId(3);
		ismael.setEmail("sm");
		ismael.setOrderExisting(false);

		users.add(ismael);
		users.add(danielle);
		users.add(scott);

		when(userRepository.GetAllUsers()).thenReturn(users);

		UserService userService = new UserService(userRepository, order);

		List<User> result = userService.GetAllUsers();

		assertEquals(users.size(), result.size());
	}

	@Test
	public void AddUser_does_not_add_user_when_email_empty() {
		IUserRepository userRepository = Mockito.mock(IUserRepository.class);
		IOrderRepository order = Mockito.mock(IOrderRepository.class);

		UserService userService = new UserService(userRepository, order);

		Response<Boolean> response = userService.AddUser("","test");

		assertEquals(false, response.getData());
	}

}