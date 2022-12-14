package com.thinhbka.authentication;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.thinhbka.authentication.model.User;
import com.thinhbka.authentication.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repository;
	
	
	
	@Test
	public void testCreateUser() {
	    User user = new User();
	    user.setEmail("ravikumar@gmail.com");
	    user.setPassword("ravi2020");
	    user.setFirstName("Ravi");
	    user.setLastName("Kumar");
	     
	    User savedUser = repository.save(user);
	     
	    User existUser = entityManager.find(User.class, savedUser.getId());
	     
	    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	     
	}
}
