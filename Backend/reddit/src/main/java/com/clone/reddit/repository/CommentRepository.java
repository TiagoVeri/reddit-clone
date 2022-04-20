package com.clone.reddit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.reddit.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
