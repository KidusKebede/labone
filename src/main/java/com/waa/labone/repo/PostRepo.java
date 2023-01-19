package com.waa.labone.repo;

import com.waa.labone.entity.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();

    public void save(Post p);

    public void delete(long id);

    public void update(long id, Post p);

    public Post getById(long id);
}
