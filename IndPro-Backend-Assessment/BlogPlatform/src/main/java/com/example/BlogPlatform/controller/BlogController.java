package com.example.BlogPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.BlogPlatform.enitty.Comment;
import com.example.BlogPlatform.enitty.Post;
import com.example.BlogPlatform.enitty.PostDto;
import com.example.BlogPlatform.service.BlogService;

@RestController
@CrossOrigin
public class BlogController {

	@Autowired
	private BlogService service;
	@PostMapping("/posts")
	public String cretaePost(@RequestBody Post post) {
		return service.createPost(post);
	}
	
	@PostMapping("/posts/{id}/comments")
	public String addComment(@PathVariable int id, @RequestBody Comment comment) {
		return service.addCommnet(id, comment);
	}
	
	@GetMapping("/posts/{id}/comments")
	public PostDto getAllComments(@PathVariable int id){
		return service.fetchAllComments(id);
	}
}
