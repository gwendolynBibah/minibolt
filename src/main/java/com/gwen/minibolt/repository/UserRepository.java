package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
