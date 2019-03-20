package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.Comment;

public interface CommentDAO extends JpaRepository<Comment, Integer> {

}
