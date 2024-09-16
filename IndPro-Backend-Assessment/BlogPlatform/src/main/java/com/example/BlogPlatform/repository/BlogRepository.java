package com.example.BlogPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BlogPlatform.enitty.Post;

@Repository
public interface BlogRepository extends JpaRepository<Post, Integer> {

}
