package com.cg.capbook.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.daoservice.FriendDAO;
import com.cg.capbook.daoservice.FriendRequestDAO;
import com.cg.capbook.exceptions.FriendRequestAlreadySentException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.model.Friend;
import com.cg.capbook.model.FriendRequest;
import com.cg.capbook.model.UserAccount;
@Component("friendServices")
public class FriendRequestImpl implements IFriendRequestServices {
	@Autowired
	private IUserService userService;
	@Autowired
	private FriendRequestDAO friendRequestDao;
	@Autowired
	private FriendDAO friendDao;
	@Override
	public boolean sendFriendRequest(String senderEmailId, String receiverEmailId) throws FriendRequestAlreadySentException  {
		if(friendRequestDao.findRequest(senderEmailId, receiverEmailId) != null) {
			throw new FriendRequestAlreadySentException("Friend Request Already Sent");
		}
		FriendRequest friendRequest = new FriendRequest();
		friendRequest.setSenderEmailId(senderEmailId);
		friendRequest.setReceiverEmailId(receiverEmailId);
		friendRequestDao.save(friendRequest);
		return true;
	}
	@Override
	public boolean confirmFriendRequest(String senderEmailId,String receiverEmailId) throws UserAccountNotFoundException {
		//		UserAccount senderUser=userService.getUserDetails(senderEmailId);
		//		UserAccount receiverUser =userService.getUserDetails(receiverEmailId);
		//		Friend senderFriend= new Friend();
		//		Friend receiverFirend = new Friend();
		//		senderFriend.setEmailId(senderEmailId);
		//		senderFriend.setFirstName(senderUser.getFirstName());
		//		senderFriend.setLastName(senderUser.getSecondName());
		//		friendDao.save(senderFriend);
		//		receiverFirend.setEmailId(receiverEmailId);
		//		receiverFirend.setFirstName(receiverUser.getFirstName());
		//		receiverFirend.setLastName(receiverUser.getSecondName());
		//		friendDao.save(receiverFirend);
		//		friendRequestDao.deleteRequest(senderEmailId, receiverEmailId);
		friendRequestDao.updateStatus(senderEmailId, receiverEmailId);
		return true;
	}
	@Override
	public boolean declineFriendRequest(String senderEmailId, String receiverEmailId) {
		friendRequestDao.deleteRequest(senderEmailId, receiverEmailId);
		return true;
	}
	@Override
	public List<FriendRequest> showAllFriendRequest(String emailId) {
		List<FriendRequest> friendRequests= friendRequestDao.findAllPendingRequest(emailId);	
		return friendRequests;
	}
	@Override
	public List<String> showAllFriends(String emailId) {
		List<FriendRequest> confirmfriends= friendRequestDao.showFriends(emailId);
		List<String> friends=new ArrayList<>();
		for(FriendRequest fr: confirmfriends){
			if(fr.getReceiverEmailId().equals(emailId))
				friends.add(fr.getSenderEmailId());
			if(fr.getSenderEmailId().equals(emailId))
				friends.add(fr.getReceiverEmailId());
		}
		return friends;
	}

}
