 package com.cg.capbook.model;
import java.util.Map;
import javax.persistence.CascadeType;
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
public class Post implements Comparable<Post> {
	@Id
	@SequenceGenerator(name="post",sequenceName="post_seq",initialValue=101,allocationSize=10000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="post")
	private int postId;
	private int totalLikeCount;
	private String postContent,postPic, timeOfPost;
	@ManyToOne
	private UserAccount user;
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	@MapKey
	private Map<Integer, Likes> likes;
	@OneToMany(mappedBy="posts",cascade=CascadeType.ALL,fetch=FetchType.EAGER,orphanRemoval=true)
	@MapKey
	private Map<Integer, Comments> comments;
	@OneToMany(mappedBy="post",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER )
	@MapKey
	private Map<Integer,Notification> notifications;
	public Post() {}
	public Post(int postId, int totalLikeCount, String postContent, String postPic, UserAccount user,
			Map<Integer, Likes> likes, Map<Integer, Comments> comments, Map<Integer, Notification> notifications) {
		super();
		this.postId = postId;
		this.totalLikeCount = totalLikeCount;
		this.postContent = postContent;
		this.postPic = postPic;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
		this.notifications = notifications;
	}
	public Post(int postId, int totalLikeCount, String postContent, String postPic, String timeOfPost, UserAccount user,
			Map<Integer, Likes> likes, Map<Integer, Comments> comments, Map<Integer, Notification> notifications) {
		super();
		this.postId = postId;
		this.totalLikeCount = totalLikeCount;
		this.postContent = postContent;
		this.postPic = postPic;
		this.timeOfPost = timeOfPost;
		this.user = user;
		this.likes = likes;
		this.comments = comments;
		this.notifications = notifications;
	}
	
	public Post(String postContent, String timeOfPost, UserAccount user) {
		super();
		this.postContent = postContent;
		this.timeOfPost = timeOfPost;
		this.user = user;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public int getTotalLikeCount() {
		return totalLikeCount;
	}
	public void setTotalLikeCount(int totalLikeCount) {
		this.totalLikeCount = totalLikeCount;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostPic() {
		return postPic;
	}
	public void setPostPic(String postPic) {
		this.postPic = postPic;
	}
	public UserAccount getUser() {
		return user;
	}
	public void setUser(UserAccount user) {
		this.user = user;
	}
	public Map<Integer, Likes> getLikes() {
		return likes;
	}
	public void setLikes(Map<Integer, Likes> likes) {
		this.likes = likes;
	}
	public Map<Integer, Comments> getComments() {
		return comments;
	}
	public void setComments(Map<Integer, Comments> comments) {
		this.comments = comments;
	}
	public Map<Integer, Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(Map<Integer, Notification> notifications) {
		this.notifications = notifications;
	}
	public String getTimeOfPost() {
		return timeOfPost;
	}
	public void setTimeOfPost(String timeOfPost) {
		this.timeOfPost = timeOfPost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((likes == null) ? 0 : likes.hashCode());
		result = prime * result + ((notifications == null) ? 0 : notifications.hashCode());
		result = prime * result + ((postContent == null) ? 0 : postContent.hashCode());
		result = prime * result + postId;
		result = prime * result + ((postPic == null) ? 0 : postPic.hashCode());
		result = prime * result + ((timeOfPost == null) ? 0 : timeOfPost.hashCode());
		result = prime * result + totalLikeCount;
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
		if (likes == null) {
			if (other.likes != null)
				return false;
		} else if (!likes.equals(other.likes))
			return false;
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		if (postContent == null) {
			if (other.postContent != null)
				return false;
		} else if (!postContent.equals(other.postContent))
			return false;
		if (postId != other.postId)
			return false;
		if (postPic == null) {
			if (other.postPic != null)
				return false;
		} else if (!postPic.equals(other.postPic))
			return false;
		if (timeOfPost == null) {
			if (other.timeOfPost != null)
				return false;
		} else if (!timeOfPost.equals(other.timeOfPost))
			return false;
		if (totalLikeCount != other.totalLikeCount)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", totalLikeCount=" + totalLikeCount + ", postContent=" + postContent
				+ ", postPic=" + postPic + ", timeOfPost=" + timeOfPost + ", user=" + user + ", likes=" + likes
				+ ", comments=" + comments + ", notifications=" + notifications + "]";
	}
	@Override
	public int compareTo(Post comparePost) {
		 int compareId=((Post)comparePost).getPostId();
		 return compareId-this.postId;
	}
		
}
