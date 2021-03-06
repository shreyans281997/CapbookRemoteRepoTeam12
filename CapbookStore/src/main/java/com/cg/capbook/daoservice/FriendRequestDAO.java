package com.cg.capbook.daoservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.capbook.model.FriendRequest;

public interface FriendRequestDAO extends JpaRepository<FriendRequest,Integer> {
	@Transactional
	@Modifying
	@Query("delete from FriendRequest fr where fr.senderEmailId=:senderEmailId and fr.receiverEmailId=:receiverEmailId and status='pending'")
    public void deleteRequest(@Param("senderEmailId") String senderEmailId,@Param("receiverEmailId") String receiverEmailId);
	@Query("from FriendRequest fr where fr.receiverEmailId=:emailId and status='pending'")
	public List<FriendRequest> findAllPendingRequest(@Param("emailId") String emailId); 
	@Query("from FriendRequest fr where fr.senderEmailId=:senderEmailId and fr.receiverEmailId=:receiverEmailId")
     public FriendRequest findRequest(@Param("senderEmailId") String senderEmailId,@Param("receiverEmailId") String receiverEmailId);
	@Query("from FriendRequest fr where fr.senderEmailId=:senderEmailId or fr.receiverEmailId=:senderEmailId")
    public FriendRequest findReq(String senderEmailId);
	@Query("from FriendRequest fr where status='confirm' and (fr.senderEmailId=:senderEmailId or fr.receiverEmailId=:senderEmailId)")
    public List<FriendRequest> showFriends(String senderEmailId);
	@Transactional
	@Modifying
	@Query("UPDATE FriendRequest fr set status = 'confirm' WHERE fr.senderEmailId=:senderEmailId and fr.receiverEmailId=:receiverEmailId")
    public void updateStatus(String senderEmailId, String receiverEmailId);
	@Transactional
	@Modifying
	@Query("delete from FriendRequest fr where ((fr.senderEmailId=:senderEmailId and fr.receiverEmailId=:receiverEmailId) or (fr.senderEmailId=:receiverEmailId and fr.receiverEmailId=:senderEmailId)) and status='confirm'")
    public void deleteFriend(@Param("senderEmailId") String senderEmailId,@Param("receiverEmailId") String receiverEmailId);
}
