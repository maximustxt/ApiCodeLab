package com.API.CodeLab.Repositorys;

import com.API.CodeLab.Models.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VideoRepository extends JpaRepository<Video , Long> {
}
