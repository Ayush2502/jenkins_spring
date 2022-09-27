//package com.example.JenkinsDemo;
//
//
//import com.example.JenkinsDemo.Entity.Users;
//import com.example.JenkinsDemo.Repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//@DataJpaTest
//public class UserRepositoryTests {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void saveUsersTest()
//    {
//        Users user = Users.builder().id(1).name("abc").email("abc@gmail.com").build();
//
//       userRepository.save(user);
//
//        Assertions.assertTrue(user.getId()>0);
//
//    }
//}
