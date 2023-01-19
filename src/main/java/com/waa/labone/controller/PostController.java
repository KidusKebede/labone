package com.waa.labone.controller;

import com.waa.labone.dto.PostDto;
import com.waa.labone.entity.Post;
import com.waa.labone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin(origins = {"http://localhost:3030"})
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll() {
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody PostDto p) {
        postService.save(p);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getById(@PathVariable long id) {
        var post = postService.getById(id);
        return ResponseEntity.ok(post);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody PostDto p) {
        postService.update(id, p);
    }
    //``````````````````````````````````````````````````````````````````````````````````````````````````````````````
    // With out DTO implementation
    //``````````````````````````````````````````````````````````````````````````````````````````````````````````````
//    @ResponseStatus(HttpStatus.OK)
//    @GetMapping
//    public List<PostDto> getAll(){ //List<Post>
//        return postService.findAll();
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping
//    public void save(@RequestBody Post p) {
//        postService.save(p);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Post> getById(@PathVariable long id) {
//        var post = postService.getById(id);
//        return ResponseEntity.ok(post);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable long id) {
//        postService.delete(id);
//    }
//
//    @PutMapping("/{id}")
//    public void update(@PathVariable("id") long id, @RequestBody Post p) {
//        postService.update(id,p);
//    }
//    //``````````````````````````````````````````````````````````````````````````````````````````````````````````````

}
