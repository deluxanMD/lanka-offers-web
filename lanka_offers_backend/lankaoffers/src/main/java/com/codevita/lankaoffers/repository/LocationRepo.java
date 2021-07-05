package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.Location;

public interface LocationRepo extends JpaRepository<Location, Long> {

}
