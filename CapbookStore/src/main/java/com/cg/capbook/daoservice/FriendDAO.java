package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.Friend;

public interface FriendDAO extends JpaRepository<Friend, String> {

}
