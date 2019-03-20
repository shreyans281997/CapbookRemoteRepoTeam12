package com.cg.capbook.services;

import com.cg.capbook.model.Post;

public interface IPostService {
	public Post updatePostLikes(Post post);
	public Post updatePostDislikes(Post post);
	Post createPostText(String emailId, String postContent);
	
}
