package com.cg.capbook.model;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class User {
	@Id
	private String emailId;
	private String password;
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Profile profile;
	@OneToMany
	private List<Photo> photos;
	//private String securityQuestion;

	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)  //mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Map<String, Friend> friends;

	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)  //mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Post> posts ;

	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true) 
	private List<Notification> notes ;
	private String gender;
	public User() {}
	
	public User(String emailId, String password, Profile profile, List<Photo> photos, Map<String, Friend> friends,
			List<Post> posts, List<Notification> notes, String gender) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.profile = profile;
		this.photos = photos;
		this.friends = friends;
		this.posts = posts;
		this.notes = notes;
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public Map<String, Friend> getFriends() {
		return friends;
	}
	public void setFriends(Map<String, Friend> friends) {
		this.friends = friends;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public List<Notification> getNotes() {
		return notes;
	}
	public void setNotes(List<Notification> notes) {
		this.notes = notes;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + ", profile=" + profile + ", photos=" + photos
				+ ", friends=" + friends + ", posts=" + posts + ", notes=" + notes + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((photos == null) ? 0 : photos.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((profile == null) ? 0 : profile.hashCode());
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
		User other = (User) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (photos == null) {
			if (other.photos != null)
				return false;
		} else if (!photos.equals(other.photos))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (profile == null) {
			if (other.profile != null)
				return false;
		} else if (!profile.equals(other.profile))
			return false;
		return true;
	}
	
	

	


}
