package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.PostLike;

public interface PostLikeRepo extends JpaRepository<PostLike, Long> {

}
