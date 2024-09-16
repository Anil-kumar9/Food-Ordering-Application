package com.example.BlogPlatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogPlatform.enitty.Comment;
import com.example.BlogPlatform.enitty.CommentDto;
import com.example.BlogPlatform.enitty.Post;
import com.example.BlogPlatform.enitty.PostDto;
import com.example.BlogPlatform.repository.BlogRepository;
import com.example.BlogPlatform.repository.CommentRepository;

@Service
public class BlogService {

	@Autowired
	private BlogRepository repo;
	
	@Autowired
	private CommentRepository commentrepo;
	
	public String createPost(Post post) {
		repo.save(post);
		return "post created successfully";
	}
	
	public String addCommnet(int id, Comment comment) {
		commentrepo.save(comment);
		return "comment added successfully";
	}
	
	public PostDto fetchAllComments(int id) {
		List<Comment> list = commentrepo.findAllByPostid(id);
		List<CommentDto> comments = new ArrayList<>();
		PostDto postDto = new PostDto();
		for(Comment comment: list) {
			CommentDto dto = new CommentDto();
			dto.setAuthorid(comment.getAuthorid());
			dto.setId(comment.getId());
			dto.setContent(comment.getContent());
			dto.setCreatedAt(comment.getCreatedAt());
			comments.add(dto);
		}
		postDto.setPost_id(id);
		postDto.setComments(comments);
		return postDto;
	}
}
