package com.cg.capbook.daoservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.model.Comments;

public interface CommentDAO extends JpaRepository<Comments, Integer> {
@Query("from Comments where POST_ID=:postId")
List<Comments> getParticularPostComments(@Param("postId") int postId);
}
