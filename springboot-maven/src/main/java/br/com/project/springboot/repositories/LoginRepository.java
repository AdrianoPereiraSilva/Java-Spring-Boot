package br.com.project.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.project.springboot.model.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long>{

	@Query("select u from User u where u.email = :#{#email} and u.password = :#{#password}")
	User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
