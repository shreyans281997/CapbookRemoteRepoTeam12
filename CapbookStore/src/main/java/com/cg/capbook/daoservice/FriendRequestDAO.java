package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.model.FriendRequest;

public interface FriendRequestDAO extends JpaRepository<FriendRequest,Integer> {

}
