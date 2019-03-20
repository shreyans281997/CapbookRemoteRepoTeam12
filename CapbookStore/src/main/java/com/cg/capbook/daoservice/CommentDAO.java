package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.Comments;

public interface CommentDAO extends JpaRepository<Comments, Integer> {

}
