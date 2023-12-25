package com.API.CodeLab.Services;

import com.API.CodeLab.Models.Curso;
import com.API.CodeLab.Models.Video;

import java.util.List;

public interface VideoServices {
    List<Video> GetVideos();
    String PostVideos(Video video);
    List<Video> DeleteVideos(Long id);
    List<Video> PutVideos(Video video , Long id);
}
