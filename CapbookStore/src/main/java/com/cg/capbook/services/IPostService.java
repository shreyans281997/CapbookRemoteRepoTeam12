package com.cg.capbook.services;

import com.cg.capbook.model.Post;

public interface IPostService {
	Post createPostText(String emailId, String postContent);
	
}
