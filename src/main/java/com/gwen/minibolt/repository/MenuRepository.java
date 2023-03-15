package com.gwen.minibolt.repository;

import com.gwen.minibolt.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {
}
