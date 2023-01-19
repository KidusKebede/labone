package com.waa.labone.service.impl;

import com.waa.labone.dto.PostDto;
import com.waa.labone.entity.Post;
import com.waa.labone.helper.ListMapper;
import com.waa.labone.repo.PostRepo;
import com.waa.labone.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public void save(PostDto p) {
        postRepo.save(modelMapper.map(p, Post.class));
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }

    @Override
    public void update(long id, PostDto p) {
        postRepo.update(id, modelMapper.map(p, Post.class));
    }

    @Override
    public PostDto getById(long id) {
        return modelMapper.map(postRepo.getById(id), PostDto.class);
    }

    @Override
    public List<PostDto> findAll() { //List<Post>

        // return postRepo.findAll();
//  return postRepo.findAll()
//          .stream()
//          .map(this::convertPostToDTO)
//          .collect(Collectors.toList());
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());
    }
    //``````````````````````````````````````````````````````````````````````````````````````````````````````````````
    // With out DTO implementation
    //``````````````````````````````````````````````````````````````````````````````````````````````````````````````
// @Override
// public void save(Post p) {
//  postRepo.save(p);
// }
//
// @Override
// public void delete(long id) {
//  postRepo.delete(id);
// }
//
// @Override
// public void update(long id, Post p) {
//  postRepo.update(id,p);
// }
//
// @Override
// public Post getById(long id) {
//  return postRepo.getById(id);
// }

//    private PostDto convertPostToDTO(Post post) {
//        PostDto postDto = new PostDto();
//        postDto.setId(post.getId());
//        postDto.setContent(post.getContent());
//        postDto.setAuthor(post.getAuthor());
//        return postDto;
//    }
}
