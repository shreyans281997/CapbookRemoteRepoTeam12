package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.model.Likes;

public interface LikesDAO extends JpaRepository<Likes, Integer>{
	@Query("from Likes where post_post_id=:post_id and liked_by=:liked_by")
	Likes findLikeByStatus(@Param("post_id")Integer post_id, @Param("liked_by")String liked_by);
	@Query("select count(*) from Likes where like_count=1 and post_post_id=:post_id")
	Integer getLikeCount(Integer post_id);
}
