package com.cg.capbook.model;
import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Profile {
private String firstName;
private String secondName;
private String bio;
private String status;
private String mobileNo;
@Id
private String userName;
@Column(columnDefinition="BLOB")
private byte[] profilePic;
@Embedded
private Address address;
@OneToOne(mappedBy="profile")
private UserAccount user;
public Profile() {}

public Profile(String firstName, String secondName, String bio, String status, String mobileNo, String userName,
		byte[] profilePic, Address address, UserAccount user) {
	super();
	this.firstName = firstName;
	this.secondName = secondName;
	this.bio = bio;
	this.status = status;
	this.mobileNo = mobileNo;
	this.userName = userName;
	this.profilePic = profilePic;
	this.address = address;
	this.user = user;
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
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public byte[] getProfilePic() {
	return profilePic;
}
public void setProfilePic(byte[] profilePic) {
	this.profilePic = profilePic;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public UserAccount getUser() {
	return user;
}
public void setUser(UserAccount user) {
	this.user = user;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((bio == null) ? 0 : bio.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
	result = prime * result + Arrays.hashCode(profilePic);
	result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	Profile other = (Profile) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (bio == null) {
		if (other.bio != null)
			return false;
	} else if (!bio.equals(other.bio))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (mobileNo == null) {
		if (other.mobileNo != null)
			return false;
	} else if (!mobileNo.equals(other.mobileNo))
		return false;
	if (!Arrays.equals(profilePic, other.profilePic))
		return false;
	if (secondName == null) {
		if (other.secondName != null)
			return false;
	} else if (!secondName.equals(other.secondName))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	return true;
}

@Override
public String toString() {
	return "Profile [firstName=" + firstName + ", secondName=" + secondName + ", bio=" + bio + ", status=" + status
			+ ", mobileNo=" + mobileNo + ", userName=" + userName + ", profilePic=" + Arrays.toString(profilePic)
			+ ", address=" + address + ", user=" + user + "]";
}



}
