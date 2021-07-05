package com.codevita.lankaoffers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codevita.lankaoffers.entity.Company;
import com.codevita.lankaoffers.entity.Post;

public interface PostRepo extends JpaRepository<Post, Long> {
	
//	//Search Query
//	@Query("SELECT p.* FROM posts LEFT JOIN lankaoffers.companies "
//			+ "ON posts.company_id = companies.id WHERE LOWER(CONCAT(posts.admin_note, posts.long_description, "
//			+ "posts.short_description, posts.status, posts.title, posts.type, companies.company_name, companies.address, "
//			+ "companies.category, companies.email, companies.location,companies.owner_address,companies.reg_no,companies.url)) LIKE %?1%")
//	public List<Post> searchIgnoreCase(String keyword);
	
	//Get Post Count by postCategory
	@Query(value ="SELECT post_categories.id, COUNT(posts.postcategory_id) AS posts FROM lankaoffers.posts "
			+ "LEFT JOIN lankaoffers.post_categories ON lankaoffers.posts.postcategory_id = post_categories.id GROUP BY posts.postcategory_id", nativeQuery =  true)
	public List<Post> getPostCountByCategory();
	
	//Get Post Count by company
	@Query(value ="SELECT company_name, COUNT(company_id) AS postCount FROM posts "
			+ "LEFT JOIN companies ON posts.company_id = companies.id GROUP BY company_id" , nativeQuery =  true)
	public List<Post> getPostCountByCompany();	
	
	//Get Post by postCategory
	@Query(value ="SELECT * FROM lankaoffers.posts WHERE posts.postcategory_id= postcategory_id", nativeQuery =  true)
	public List<Post> getPostByCategory(@Param("postcategory_id") Long postcategory_id);
	
	//Get Post by company
	@Query(value ="SELECT * FROM lankaoffers.posts WHERE posts.company_id = company_id" , nativeQuery =  true)
	public List<Post> getPostByCompany(@Param("company_id") Long company_id);
	
	//Get Latest Post
	@Query(value = "SELECT * FROM posts ORDER BY created_at DESC", nativeQuery = true)
	List<Post> getLatestPosts();
			
	//Get Deal of the day Post
	@Query(value ="SELECT * FROM lankaoffers.posts WHERE DATE(`offer_valid_until`) = CURDATE()", nativeQuery =  true)
	public List<Post> getDealsOfTheDay();
	
	//Get Popular Post
	@Query(value ="SELECT p.*, ifnull(v.vc,0) as views from posts p\r\n" + 
			"left join (select post_id, count(*) as vc from post_views group by post_id) v  ON p.id = v.post_id  ORDER BY v.vc desc limit 10", nativeQuery =  true)
	public List<Post> getPopularPost();
	
}
