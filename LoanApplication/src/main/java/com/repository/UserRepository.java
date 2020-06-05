package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vo.User;

public interface UserRepository extends CrudRepository<User, Long> {
	//  @Query(value="select id from User u  where u.name=:uname and u.password=:pass")
	//@Transactional
    @Query(value="select id from User u where u.name=?1 and  u.password=?2", nativeQuery = true)
	Optional<Long> valiidate(@Param("uname") String uName, @Param("pass") String pass);
    @Query(value="select id from User u where u.name=?1", nativeQuery = true)
	Optional<Long> findByUserName(@Param("uname") String username);

}
