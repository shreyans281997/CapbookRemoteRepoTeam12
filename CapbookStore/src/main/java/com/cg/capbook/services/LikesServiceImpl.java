package com.cg.capbook.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.daoservice.LikesDAO;
import com.cg.capbook.daoservice.PostDAO;
import com.cg.capbook.model.Likes;
import com.cg.capbook.model.Post;
@Component("likesService")
public class LikesServiceImpl implements ILikesService {
	@Autowired
	private LikesDAO likesDao;
	@Autowired 
	private PostDAO postDao;
	@Override
	public Likes updateLikes(int postId, String likedBy) {
		Likes alreadyLiked=likesDao.findLikeByStatus(postId, likedBy);
		if(alreadyLiked!=null){
			alreadyLiked.setLike_count(0);
			return likesDao.save(alreadyLiked);
		}else {
			return likesDao.save(new Likes(likedBy, 1, 0, postDao.findById(postId).orElse(null)));
		}
	}
	@Override
	public int getLikesCount(int postId) {
		return likesDao.getLikeCount(postId);
	}
	@Override
	public Likes updateDislikes(int postId, String dislikedBy) {
		Likes alreadyLiked=likesDao.findLikeByStatus(postId, dislikedBy);
		if(alreadyLiked!=null){
			alreadyLiked.setDislike_count(0);
			return likesDao.save(alreadyLiked);
		}else {
			return likesDao.save(new Likes(dislikedBy,  postDao.findById(postId).orElse(null), 0, 1));
		}
	}
	@Override
	public int getDislikesCount(int postId) {
		return likesDao.getDislikeCount(postId);	}
}
