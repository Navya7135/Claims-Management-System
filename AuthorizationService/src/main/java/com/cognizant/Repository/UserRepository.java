package com.cognizant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByMemberId(String username);

}
