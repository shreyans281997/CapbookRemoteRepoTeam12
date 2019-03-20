package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.UserAccount;

public interface UserDAO  extends JpaRepository<UserAccount, String>{

}
