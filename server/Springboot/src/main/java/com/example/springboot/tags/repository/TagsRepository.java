package com.example.springboot.tags.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.tags.model.Tags;

@Repository
public interface TagsRepository extends JpaRepository<Tags, Long> {

}