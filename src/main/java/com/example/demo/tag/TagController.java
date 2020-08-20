package com.example.demo.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping()
    public List<Tag> getTag() {
        return tagService.retrieveTag();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTag(@PathVariable Long id) {
        Optional<Tag> tag = tagService.retrieveTag(id);
        if(!tag.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tag);
    }

    @GetMapping("/search")
    public List<Tag> getTag(@RequestParam(value = "Name") String Name ) {
        return tagService.retrieveTag(Name);
    }

    @PostMapping()
    public ResponseEntity<?> postTag(@Valid @RequestBody Tag body) {
        Tag tag = tagService.createTag(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(tag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putTag(@PathVariable Long id, @Valid @RequestBody Tag body) {
        Optional<Tag> tag = tagService.updateTag(id, body);
        if(!tag.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTag(@PathVariable Long id) {
        if(!tagService.deleteTag(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

}