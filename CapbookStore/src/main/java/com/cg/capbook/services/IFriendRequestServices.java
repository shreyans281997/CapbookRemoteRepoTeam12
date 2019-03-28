package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.exceptions.FriendRequestAlreadySentException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.FriendRequest;

public interface IFriendRequestServices {
	  public boolean sendFriendRequest(String senderEmailId, String receiverEmailId) throws UserAccountNotFoundException, FriendRequestAlreadySentException;
	    public boolean confirmFriendRequest(String senderEmailId,String receiverEmailId) throws UserAccountNotFoundException;
	    public boolean declineFriendRequest(String senderEmailId, String receiverEmailId);
        public List<FriendRequest> showAllFriendRequest(String emailId);
}
