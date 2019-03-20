package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.Profile;

public interface ProfileDAO extends JpaRepository<Profile, String>{

}
