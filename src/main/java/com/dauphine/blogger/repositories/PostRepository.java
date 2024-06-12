package com.dauphine.blogger.repositories;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {

    List<Post> findAllByCategoryId(UUID categoryId);

    @Query("SELECT post FROM Post post WHERE post.Title=:title")
    Post findByTitle(String title);

    @Query("SELECT post FROM Post post WHERE post.category.id IN (SELECT category.id FROM Category category WHERE UPPER(category.name) LIKE UPPER(CONCAT('%', :name, '%')))")
    List<Post> findAllByCategoryName(@Param("name") String name);




}
