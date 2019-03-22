package com.cg.capbook.daoservice;



import org.springframework.data.jpa.repository.JpaRepository;


import com.cg.capbook.model.Photo;

public interface PhotoDAO extends JpaRepository<Photo, Integer>{

}
