package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.Post;

public interface PostDAO extends JpaRepository<Post, Integer>{

}
