package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TownRepository extends JpaRepository<Town, String> {
    Optional<Town> findByNameIgnoreCase(String name);
}