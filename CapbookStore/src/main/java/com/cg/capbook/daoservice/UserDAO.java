package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.User;

public interface UserDAO  extends JpaRepository<User, String>{

}
