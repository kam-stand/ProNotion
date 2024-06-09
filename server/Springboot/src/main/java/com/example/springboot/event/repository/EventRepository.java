package com.example.springboot.event.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot.event.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}