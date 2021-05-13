package com.ust.book.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.book.model.User;

//@Repository
//public interface UserRepository extends JpaRepository<User, String>{
//
//}
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	User findByUserId(String id);

}
