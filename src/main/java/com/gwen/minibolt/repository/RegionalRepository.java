package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Regional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionalRepository extends JpaRepository<Regional, String> {
    Optional<Regional> findByRegion(String region);
}