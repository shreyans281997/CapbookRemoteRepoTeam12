package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.model.Post;

public interface IPostService {
	Post createPostText(String emailId, String postContent);
	List<Post> allPosts(String emaildId);
	public boolean deletePost(int postId);
	public Post showSinglePost(int postId);
	public List<Post> showAllFriendsPosts(String emailId);
}
