package com.cg.capbook.model;

import java.util.Arrays;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Post {
	@Id
	@SequenceGenerator(name="post_seq",sequenceName="post_seq",initialValue=101,allocationSize=10000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="post_seq")
	private int postId;
	private String postContent;
	@ManyToOne
	private User user;
	@Column(columnDefinition="BLOB")
	private byte[] postPic;
	private int noOfPostLikes;
	private int noOfPostDislikes;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@MapKey
	private Map<Integer, Comment> comments;
	
	public Post() {}

	public Post(int postId, String postContent, User user, byte[] postPic, int noOfPostLikes, int noOfPostDislikes,
			Map<Integer, Comment> comments) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.user = user;
		this.postPic = postPic;
		this.noOfPostLikes = noOfPostLikes;
		this.noOfPostDislikes = noOfPostDislikes;
		this.comments = comments;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getPostPic() {
		return postPic;
	}

	public void setPostPic(byte[] postPic) {
		this.postPic = postPic;
	}

	public int getNoOfPostLikes() {
		return noOfPostLikes;
	}

	public void setNoOfPostLikes(int noOfPostLikes) {
		this.noOfPostLikes = noOfPostLikes;
	}

	public int getNoOfPostDislikes() {
		return noOfPostDislikes;
	}

	public void setNoOfPostDislikes(int noOfPostDislikes) {
		this.noOfPostDislikes = noOfPostDislikes;
	}

	public Map<Integer, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Integer, Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postContent=" + postContent + ", user=" + user + ", postPic="
				+ Arrays.toString(postPic) + ", noOfPostLikes=" + noOfPostLikes + ", noOfPostDislikes="
				+ noOfPostDislikes + ", comments=" + comments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + noOfPostDislikes;
		result = prime * result + noOfPostLikes;
		result = prime * result + ((postContent == null) ? 0 : postContent.hashCode());
		result = prime * result + postId;
		result = prime * result + Arrays.hashCode(postPic);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (noOfPostDislikes != other.noOfPostDislikes)
			return false;
		if (noOfPostLikes != other.noOfPostLikes)
			return false;
		if (postContent == null) {
			if (other.postContent != null)
				return false;
		} else if (!postContent.equals(other.postContent))
			return false;
		if (postId != other.postId)
			return false;
		if (!Arrays.equals(postPic, other.postPic))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
