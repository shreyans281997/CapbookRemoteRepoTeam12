package com.cg.capbook.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.capbook.daoservice.PostDAO;
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.model.Likes;
import com.cg.capbook.model.Post;
import com.cg.capbook.model.UserAccount;
@Component("postService")
public class PostServicesimpl implements IPostService {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private PostDAO postDao;
	@Override
	public Post createPostText(String emailId, String postContent) {
		UserAccount user=userDao.findById(emailId).orElse(null);
		Post post=new Post(postContent, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")), user);
		return postDao.save(post);
	}
	@Override
	public List<Post> allPosts(String emailId) {
		return postDao.showAllPosts(emailId);
		
	}
	public boolean deletePost(int postId) {
		postDao.deleteById(postId);
		return true;
	}
	public Post showSinglePost(int postId) {
		return postDao.findById(postId).orElse(null);
	}


}
