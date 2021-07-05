package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.PublicGuest;

public interface PublicGuestRepo extends JpaRepository<PublicGuest, Long> {

}
