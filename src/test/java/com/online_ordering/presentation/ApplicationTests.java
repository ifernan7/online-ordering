package com.online_ordering.presentation;

import com.online_ordering.order.abstractions.IOrderRepository;
import com.online_ordering.user.User;
import com.online_ordering.user.UserService;
import com.online_ordering.user.abstractions.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

//@SpringBootTest
class ApplicationTests {

	@Test
	public void someTest() {

		IUserRepository userRepository = Mockito.mock(IUserRepository.class);
		IOrderRepository order = Mockito.mock(IOrderRepository.class);


		List<User> list = new ArrayList<>();
		User ismael = new User();
		ismael.setId(1);
		ismael.setEmail("ifern");
		ismael.setOrderExisting(false);

		list.add(ismael);

		when(userRepository.GetAllUsers()).thenReturn(list);



		UserService userService = new UserService(userRepository, order);

		List<User> result = userService.GetAllUsers();

		String name = null;

		assertNotNull(name);
	}
}