package br.com.myreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myreview.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
