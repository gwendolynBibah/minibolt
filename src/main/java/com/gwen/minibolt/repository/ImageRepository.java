package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Byte> {
}
