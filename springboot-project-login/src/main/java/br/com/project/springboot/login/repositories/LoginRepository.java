package br.com.project.springboot.login.repositories;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.project.springboot.login.model.User;

public interface LoginRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.email = :#{#email} and u.password = :#{#password}")
	User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
