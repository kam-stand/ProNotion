package com.example.springboot.repository;

import com.example.springboot.model.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository<Tags,Long> {
}
