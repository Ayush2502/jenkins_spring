package com.example.JenkinsDemo.Repository;

import com.example.JenkinsDemo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
