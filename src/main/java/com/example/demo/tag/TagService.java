package com.example.demo.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository repository) {
        this.tagRepository = repository;
    }

    public List<Tag> retrieveTag() {
        return (List<Tag>) tagRepository.findAll();
    }

    public Optional<Tag> retrieveTag(Long id) {
        return tagRepository.findById(id);
    }

    public List<Tag> retrieveTag(String Name) {
        return null;
    }

    public Tag createTag(Tag tag) {

        return tagRepository.save(tag);
    }

    public Optional<Tag> updateTag(Long id, Tag tag) {
        Optional<Tag> tagOptional = tagRepository.findById(id);
        if(!tagOptional.isPresent()) {
            return tagOptional;
        }

        return Optional.of(tagRepository.save(tag));
    }

    public boolean deleteTag(Long id) {
        try {
            tagRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}