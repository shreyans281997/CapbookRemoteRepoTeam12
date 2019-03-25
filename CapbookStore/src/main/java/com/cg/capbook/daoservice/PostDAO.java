package com.cg.capbook.daoservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.model.Post;

public interface PostDAO extends JpaRepository<Post, Integer>{
	@Query("from Post where USER_EMAIL_ID=:emailId")
	public List<Post> showAllPosts(String emailId);
}
