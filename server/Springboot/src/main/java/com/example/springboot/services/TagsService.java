package com.example.springboot.services;

import com.example.springboot.model.Tags;
import com.example.springboot.repository.TagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsService {

    @Autowired
    private TagsRepository tagsRepository;

    public Tags createTags(Tags tags) {
        return tagsRepository.save(tags);
    }




}
