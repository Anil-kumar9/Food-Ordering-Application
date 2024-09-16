package com.example.BlogPlatform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BlogPlatform.enitty.Comment;
import com.example.BlogPlatform.enitty.Post;
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
	
	public List<Comment> fetchAllComments(int id) {
		return commentrepo.findAllByPostid(id);
	}
}
