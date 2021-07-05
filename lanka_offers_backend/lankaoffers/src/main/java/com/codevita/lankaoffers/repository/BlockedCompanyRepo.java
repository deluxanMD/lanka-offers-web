package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.BlockedCompany;

public interface BlockedCompanyRepo extends JpaRepository<BlockedCompany, Long> {

}
