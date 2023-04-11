package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImageRepository extends JpaRepository<Image, String> {
}
