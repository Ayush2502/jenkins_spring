package com.example.JenkinsDemo.Controller;


import com.example.JenkinsDemo.Entity.Users;
import com.example.JenkinsDemo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @GetMapping("/allusers")
    public List<Users> getall()
    {
       return userRepository.findAll();
    }


    @PostMapping("/adduser")
    public String addusers(@RequestBody Users user)
    {
       userRepository.save(user) ;
       return "User Saved Successfully in the db";
    }

   
    @PutMapping("/update/{id}")
    public String update(@PathVariable int id,@RequestBody Users user)
    {
        boolean found = false;
        ArrayList<Users> list = (ArrayList<Users>) userRepository.findAll();
        for(Users i:list)
        {
            if(i.getId()==id)
            {
                found=true;
                break;
            }
        }
        if(found)
        {
            Optional<Users> u1 = userRepository.findById(id);
           Users olduser= u1.get();
           olduser.setId(user.getId());
           olduser.setName(user.getName());
           olduser.setEmail(user.getEmail());
           userRepository.save(olduser);
        }
        else
            userRepository.save(user);

        System.out.println("Hello World 12345");
        return "User Updated Successfully into the database";
    }
   

}
