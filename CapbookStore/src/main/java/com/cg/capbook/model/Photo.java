package com.cg.capbook.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Photo {
	@Id
	@SequenceGenerator(name="photo_seq",sequenceName="photo_seq",initialValue=1001,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="photo_seq")
	private int photoId;
	
	private String type;
	
	@ManyToOne
	UserAccount user;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	public Photo(int photoId, String type, UserAccount user) {
		super();
		this.photoId = photoId;
		this.type = type;
		this.user = user;
	}

	public Photo() {
		super();
	}
}
