package com.cg.capbook.daoservice;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.capbook.model.Notification;

public interface NotificationDAO extends JpaRepository<Notification, Integer> {

}
