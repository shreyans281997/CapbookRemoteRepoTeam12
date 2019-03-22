package com.cg.capbook.daoservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.capbook.model.FriendRequest;

public interface FriendRequestDAO extends JpaRepository<FriendRequest,Integer> {
	@Query("delete from FriendRequest fr where fr.senderEmailId=:senderEmailId and fr.receiverEmailId=:receiverEmailId")
    public boolean deleteRequest(@Param("senderEmailId") String senderEmailId,@Param("receiverEmailId") String receiverEmailId);
	@Query("from FriendRequest fr where fr.receiverEmailId=:emailId")
	public List<FriendRequest> findAllPendingRequest(@Param("emailId") String emailId); 
}
