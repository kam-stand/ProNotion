package com.example.springboot.tags.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springboot.tags.repository.TagsRepository;
import com.example.springboot.tags.model.Tags;

@Service
public class TagsService {
    @Autowired
    private TagsRepository tagsRepository;

    // save a tag
    public Tags save(Tags tag) {
        return tagsRepository.save(tag);
    }

    // find a tag by id
    public Tags findById(Long id) {
        return tagsRepository.findById(id).orElse(null);
    }

    // delete a tag by id
    public void deleteById(Long id) {
        tagsRepository.deleteById(id);
    }

    // update a tag
    public Tags update(Tags tag, Long id) {
        Tags existingTag = tagsRepository.findById(id).orElse(null);
        if (existingTag != null) {
            return tagsRepository.save(existingTag);
        }
        return null;
    }

}
