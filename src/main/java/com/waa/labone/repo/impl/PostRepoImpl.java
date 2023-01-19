package com.waa.labone.repo.impl;

import com.waa.labone.entity.Post;
import com.waa.labone.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static long postId = 111;

    static {
        //implementation
        posts = new ArrayList<>();
        Post p1 = new Post(1L, "Feedback", "Please fix the error!", "Kidus Kebede");
        Post p2 = new Post(2L, "Praise", "Great Job!", "John Smith");

        posts.add(p1);
        posts.add(p2);

    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public void save(Post p) {
        p.setId(postId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        postId++;
        posts.add(p);
    }

    @Override
    public void delete(long id) {
        var product = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(product);
    }

    @Override
    public void update(long id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());

    }

    public Post getById(long id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }
}
