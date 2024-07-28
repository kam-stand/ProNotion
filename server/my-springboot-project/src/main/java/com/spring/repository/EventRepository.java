package com.spring.repository;

// Ensure this import is present at the top of your file
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // You can define custom query methods here if needed
}