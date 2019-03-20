package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.capbook.daoservice.PostDAO;
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.model.Post;
import com.cg.capbook.model.UserAccount;

public class PostServicesimpl implements IPostService {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private PostDAO postDao;
	@Override
	public Post createPostText(String emailId,String postContent) {
		UserAccount user=userDao.findById(emailId).orElse(null);
		Post postMsg=new Post(postContent, user,0,0);
		return postMsg;
}

	@Override
	public Post updatePostLikes(Post post) {
		Post oldPost=postDao.findById(post.getPostId()).get();
		post.setNoOfPostLikes(oldPost.getNoOfPostLikes()+1);
		return postDao.save(post);
	}

	@Override
	public Post updatePostDislikes(Post post) {
		Post oldPost=postDao.findById(post.getPostId()).get();
		post.setNoOfPostLikes(oldPost.getNoOfPostDislikes()+1);
		return postDao.save(post);
	}

}
