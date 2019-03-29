package com.cg.capbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.daoservice.CommentDAO;
import com.cg.capbook.daoservice.PostDAO;
import com.cg.capbook.model.Comments;
@Component("commentServices")
public class CommentServices implements ICommentServices {
@Autowired
private CommentDAO commentDao;
@Autowired
private PostDAO postDao;
@Override
public Comments saveComment(int postId,String emailId,String commentContent) {
	Comments comment=new Comments();
	comment.setCommentContent(commentContent);
	comment.setCommentPerson(emailId);
	comment.setPosts(postDao.findById(postId).orElse(null));
	return commentDao.save(comment);
}
@Override
public List<Comments> getAllComments() {
	return commentDao.findAll();
}
@Override
public List<Comments> getPostComments(int postId) {
	return commentDao.getParticularPostComments(postId);
}



}
