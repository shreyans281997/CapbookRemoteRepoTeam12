package com.cg.capbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Likes {
	@Id
	@SequenceGenerator(name="likes",sequenceName="like_seq",initialValue=1001,allocationSize=10000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="likes")
	private Integer likeId;
	private String likedBy;
	private int like_count;
	@ManyToOne
	private Post post;
	
	public Likes() {}
	public Likes(Integer likeId, String likedBy, String dislikedBy, int like_count, Post post) {
		super();
		this.likeId = likeId;
		this.likedBy = likedBy;
		this.like_count = like_count;
		this.post = post;
	}

	public Likes(String likedBy, int like_count, Post post) {
		super();
		this.likedBy = likedBy;
		this.like_count = like_count;
		this.post = post;
	}
	
	public Likes(String dislikedBy,Post post, int like_count) {
		super();
		this.like_count = like_count;
		this.post = post;
	}
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public String getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", likedBy=" + likedBy + ", like_count="
				+ like_count + ", post=" + post + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((likeId == null) ? 0 : likeId.hashCode());
		result = prime * result + like_count;
		result = prime * result + ((likedBy == null) ? 0 : likedBy.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
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
		Likes other = (Likes) obj;
		if (likeId == null) {
			if (other.likeId != null)
				return false;
		} else if (!likeId.equals(other.likeId))
			return false;
		if (like_count != other.like_count)
			return false;
		if (likedBy == null) {
			if (other.likedBy != null)
				return false;
		} else if (!likedBy.equals(other.likedBy))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		return true;
	}
	
}
