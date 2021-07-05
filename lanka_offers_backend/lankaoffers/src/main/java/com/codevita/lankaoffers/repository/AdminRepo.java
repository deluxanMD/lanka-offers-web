package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {

}
