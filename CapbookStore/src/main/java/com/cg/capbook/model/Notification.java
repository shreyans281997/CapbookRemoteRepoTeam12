package com.cg.capbook.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Notification {
	@Id
	@SequenceGenerator(name="notification",initialValue=50000,allocationSize=50000,sequenceName="notificationSequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="notification")
	private int notificationId;
	private String notificationContent;
	@ManyToOne
	private Post post;
	public Notification() {}
	public Notification(String notificationContent, Post post) {
		super();
		this.notificationContent = notificationContent;
		this.post = post;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getNotificationContent() {
		return notificationContent;
	}
	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notificationContent == null) ? 0 : notificationContent.hashCode());
		result = prime * result + notificationId;
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
		Notification other = (Notification) obj;
		if (notificationContent == null) {
			if (other.notificationContent != null)
				return false;
		} else if (!notificationContent.equals(other.notificationContent))
			return false;
		if (notificationId != other.notificationId)
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		return true;
	}
}
