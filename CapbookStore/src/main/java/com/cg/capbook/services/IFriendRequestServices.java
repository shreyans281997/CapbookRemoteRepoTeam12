package com.cg.capbook.services;

import com.cg.capbook.exceptions.UserAccountNotFoundException;

public interface IFriendRequestServices {
	  public boolean sendFriendRequest(String senderEmailId, String receiverEmailId) throws UserAccountNotFoundException;
	    public boolean confirmFriendRequest(String senderEmailId,String receiverEmailId) throws UserAccountNotFoundException;
	    public boolean declineFriendRequest(String senderEmailId, String receiverEmailId);
        public void showAllFriendRequest(String emailId);
}
