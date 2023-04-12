package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.MiniboltUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiniboltUserRepository extends JpaRepository<MiniboltUser, Long> {
}
