package com.cg.capbook.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.model.Likes;

public interface ILikesService {
	public Likes updateLikes(int postId, String likedBy);
	public int getLikesCount(int postId);
	public Likes updateDislikes(int postId, String dislikedBy);
	public int getDislikesCount(int postId);

}
