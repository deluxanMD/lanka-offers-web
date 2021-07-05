package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.Setting;

public interface SettingRepo extends JpaRepository<Setting, Long> {

}
