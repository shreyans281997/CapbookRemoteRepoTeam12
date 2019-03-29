package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.model.Comments;

public interface ICommentServices {
Comments saveComment(int postId, String emailId, String commentContent);
List<Comments> getAllComments();

List<Comments> getPostComments(int postId);
}
