package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.LoginHistory;

public interface LoginHistoryRepo extends JpaRepository<LoginHistory, Long> {

}
