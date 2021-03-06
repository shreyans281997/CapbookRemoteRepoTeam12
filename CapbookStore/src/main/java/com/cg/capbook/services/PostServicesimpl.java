package com.cg.capbook.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.daoservice.FriendRequestDAO;
import com.cg.capbook.daoservice.PostDAO;
import com.cg.capbook.daoservice.UserDAO;
import com.cg.capbook.model.FriendRequest;
import com.cg.capbook.model.Post;
import com.cg.capbook.model.UserAccount;
@Component("postService")
public class PostServicesimpl implements IPostService {
	@Autowired
	private UserDAO userDao;
	@Autowired
	private PostDAO postDao;
	@Autowired
	private FriendRequestDAO friendDao;
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
		postDao.delete(showSinglePost(postId));
		return true;
	}
	public Post showSinglePost(int postId) {
		return postDao.findById(postId).orElse(null);
	}
	@Override
	public List<Post> showAllFriendsPosts(String emailId) {
		List<Post> posts=new ArrayList<Post>();
		List<String> confirmFriends=new ArrayList<>();
		List<FriendRequest> friends=friendDao.showFriends(emailId);
		for(FriendRequest fr: friends){
			if(fr.getReceiverEmailId().equals(emailId))
				confirmFriends.add(fr.getSenderEmailId());
			if(fr.getSenderEmailId().equals(emailId))
				confirmFriends.add(fr.getReceiverEmailId());
		}
		for(String str:confirmFriends) {
			for(Post post: postDao.showAllPosts(str)) {
			posts.add(post);	
			}
		}
		posts.addAll(allPosts(emailId));
		Collections.sort(posts);
		return posts;
		}
}
