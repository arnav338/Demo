package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.project.controllers.UserController;
import com.project.entities.User;
import com.project.repositories.UserRepo;
import com.project.services.UserServiceImpl;
import com.project.tests.TestConfig;

@ContextConfiguration(classes = { TestConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MealTests {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserRepo userRepo;;
	
	public void setup() throws Exception {
		
		userServiceImpl = new UserServiceImpl();
		ReflectionTestUtils.setField(userController, "userServiceImpl", userServiceImpl);
		
		ReflectionTestUtils.setField(userServiceImpl, "userRepo", userRepo);
		
	}
	
	@Test
	public void addTestUser() throws Exception {
		setup();
		User user = new User();
		user.setFirstName("testUserFirstName");
		user.setLastName("testUserLastName");
		user.setGender("Male");
		user.setContactNumber("123435456");
		user.setEmail("test@test.com");
		user.setPassword("testPassword");
		
		boolean userRegistered = userController.registerUser(user);
		
		assertTrue(userRegistered);
		
	}
	
	@Test
	public void loginUserSuccess() throws Exception {
		setup();
		User user = new User();
		user.setEmail("test@test.com");
		user.setPassword("testPassword");
		
		String authenticationMessage = userController.loginUser(user);
		
		assertEquals("Password matched", authenticationMessage);
		
	}
	
	@Test
	public void loginUserFail() throws Exception {
		setup();
		User user = new User();
		user.setEmail("test@test.com");
		user.setPassword("stPassword");
		
		String authenticationMessage = userController.loginUser(user);
		
		assertEquals("Password authentication failed", authenticationMessage);
		
	}
	
}
