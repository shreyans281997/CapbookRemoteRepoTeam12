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
		if(alreadyLiked!=null) {
			if(alreadyLiked.getLike_count()==1){
				alreadyLiked.setLike_count(0);
				return likesDao.save(alreadyLiked);
			}else {
				alreadyLiked.setLike_count(1);
				return likesDao.save(alreadyLiked);
			}
		}return likesDao.save(new Likes(likedBy, 1, postDao.findById(postId).orElse(null)));

	}

	@Override
	public int getLikesCount(int postId) {
		Post post=postDao.findById(postId).orElse(null);
		post.setTotalLikeCount(likesDao.getLikeCount(postId));
		postDao.save(post);
		return  post.getTotalLikeCount();
	}

	
}
