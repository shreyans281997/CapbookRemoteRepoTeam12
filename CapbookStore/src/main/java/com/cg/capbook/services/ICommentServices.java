package com.cg.capbook.services;

import com.cg.capbook.model.Comments;

public interface ICommentServices {
Comments saveComment(int postId, String emailId, String commentContent);
Comments getAllComments();
}
