package com.example.springboot.tags.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springboot.tags.services.TagsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.springboot.tags.model.Tags;

@RestController
@RequestMapping("/tags")
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @PostMapping("/newTag")
    public Tags postNewTag(@RequestBody Tags tag) {
        if (tag.getTag_name() == null) {
            return null;
        }
        return tagsService.save(tag);
    }

    @PostMapping("/updateTag")
    public Tags postUpdateTag(@RequestBody Tags tag, long id) {
        if (tag.getTag_name() == null) {
            return null;
        }
        return tagsService.update(tag, id);
    }

    @PostMapping("/deleteTag")
    public void postDeleteTag(long id) {
        tagsService.deleteById(id);
    }

}
