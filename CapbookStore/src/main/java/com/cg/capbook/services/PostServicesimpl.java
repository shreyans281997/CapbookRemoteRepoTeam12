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
	public Post updatePostLikes(Post post) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Post updatePostDislikes(Post post) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Post createPostText(String emailId, String postContent) {
		// TODO Auto-generated method stub
		return null;
	}


}
