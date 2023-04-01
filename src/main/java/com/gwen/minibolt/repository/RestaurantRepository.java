package com.gwen.minibolt.repository;

import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    List<Restaurant> findAllByOwnerId(Long owner_id);

    List<Restaurant> findAllByLocation(String location);

    List<Restaurant> findAllByStatusAndLocation(GENERAL_STATUS status, String location);

    List<Restaurant> findAllByStatus(GENERAL_STATUS status);

    Optional<Restaurant> findByIdAndStatus(Long restaurantId, GENERAL_STATUS status);

}
