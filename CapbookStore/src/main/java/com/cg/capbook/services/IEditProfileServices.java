package com.cg.capbook.services;

import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.UserAccount;

public interface IEditProfileServices {
public  UserAccount editBio(String emailId,String bio) throws UserAccountNotFoundException;
public UserAccount editWorkPlaceAndWorkExperience(String emailId, String workPlace,String workExperience ) throws UserAccountNotFoundException;
public UserAccount editAddress(String emailId,String city,String state,String country,String zipCode) throws UserAccountNotFoundException;
}
