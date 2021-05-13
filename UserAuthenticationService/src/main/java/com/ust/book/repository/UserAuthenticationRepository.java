package com.ust.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ust.book.model.User;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<User, String>{
	
	User findByUserIdAndUserPassword(String id, String password);
	
	User findByUserId(String id);
}
