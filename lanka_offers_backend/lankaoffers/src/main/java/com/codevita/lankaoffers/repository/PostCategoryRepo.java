package com.codevita.lankaoffers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codevita.lankaoffers.entity.PostCategory;

public interface PostCategoryRepo extends JpaRepository<PostCategory, Long> {

}
