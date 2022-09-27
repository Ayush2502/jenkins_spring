package com.example.JenkinsDemo;

import com.example.JenkinsDemo.Entity.Users;
import com.example.JenkinsDemo.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@SpringBootTest
@WebMvcTest
class JenkinsDemoApplicationTests {


	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserRepository userRepository;

	@Test
	void getallusersTest() throws Exception {

		Mockito.when(userRepository.findAll()).thenReturn(Collections.emptyList());

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/allusers").accept(MediaType.APPLICATION_JSON)
		).andReturn();


		System.out.println(result.getResponse());
		Mockito.verify(userRepository).findAll();
	}
	@Test
	void addusersTest() throws Exception
	{
		Users users = new Users(4,"def","def@gamil.com");
		Mockito.when(userRepository.save(users)).thenReturn(users);
		assertEquals(users,userRepository.save(users));
		Mockito.verify(userRepository).save(users);
	}

	@Test
	void deleteeusersTest() throws Exception
	{
		Users users = new Users(4,"def","def@gamil.com");
   userRepository.delete(users);
   verify(  userRepository,times(1)).delete(users);

	}

}
