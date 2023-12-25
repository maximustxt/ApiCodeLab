package com.API.CodeLab.Repositorys;

import com.API.CodeLab.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog , Long> {
}
