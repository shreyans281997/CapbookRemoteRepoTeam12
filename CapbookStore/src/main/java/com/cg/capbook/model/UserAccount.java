package com.cg.capbook.model;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class UserAccount {
	@Id
	private String emailId;
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<Photo> photos;

	@OneToMany(mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)  //mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private Map<String, Friend> friends;

	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)  //mappedBy="user",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Post> posts ;

	private String gender,firstName,secondName,bio,status,mobileNo,dateOfBirth,userName,securityQue,answer;
	private String profilePic;
	@Embedded
	private Address address;
	public UserAccount() {}
	public UserAccount(String emailId, String password, List<Photo> photos, Map<String, Friend> friends,
			List<Post> posts, String gender, String firstName, String secondName, String bio, String status,
			String mobileNo, String dateOfBirth, String userName, String securityQue, String answer, String profilePic,
			Address address) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.photos = photos;
		this.friends = friends;
		this.posts = posts;
		this.gender = gender;
		this.firstName = firstName;
		this.secondName = secondName;
		this.bio = bio;
		this.status = status;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.userName = userName;
		this.securityQue = securityQue;
		this.answer = answer;
		this.profilePic = profilePic;
		this.address = address;
	}
   public UserAccount(String emailId, String password, String gender, String firstName, String secondName,
			String mobileNo, String dateOfBirth,String securityQue,String answer) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.gender = gender;
		this.firstName = firstName;
		this.secondName = secondName;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.securityQue = securityQue;
		this.answer = answer;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getSecurityQue() {
		return securityQue;
	}
    public void setSecurityQue(String securityQue) {
		this.securityQue = securityQue;
	}
    public String getAnswer() {
		return answer;
	}
    public void setAnswer(String answer) {
		this.answer = answer;
	}
   


	@Override
	public String toString() {
		return "UserAccount [emailId=" + emailId + ", password=" + password + ", photos=" + photos + ", friends="
				+ friends + ", posts=" + posts + ", gender=" + gender + ", firstName=" + firstName + ", secondName="
				+ secondName + ", bio=" + bio + ", status=" + status + ", mobileNo=" + mobileNo + ", dateOfBirth="
				+ dateOfBirth + ", userName=" + userName + ", securityQue=" + securityQue + ", answer=" + answer
				+ ", profilePic=" + profilePic + ", address=" + address + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((bio == null) ? 0 : bio.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((photos == null) ? 0 : photos.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((profilePic == null) ? 0 : profilePic.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + ((securityQue == null) ? 0 : securityQue.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		UserAccount other = (UserAccount) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (bio == null) {
			if (other.bio != null)
				return false;
		} else if (!bio.equals(other.bio))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
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
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
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
		if (profilePic == null) {
			if (other.profilePic != null)
				return false;
		} else if (!profilePic.equals(other.profilePic))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		if (securityQue == null) {
			if (other.securityQue != null)
				return false;
		} else if (!securityQue.equals(other.securityQue))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
}
