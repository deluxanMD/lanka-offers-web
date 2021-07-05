package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.ActivityLog;

public interface ActivityLogRepo extends JpaRepository<ActivityLog, Long> {

}
