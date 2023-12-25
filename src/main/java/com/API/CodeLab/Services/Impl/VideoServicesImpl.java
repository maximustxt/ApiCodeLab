package com.API.CodeLab.Services.Impl;

import com.API.CodeLab.Models.Video;
import com.API.CodeLab.Repositorys.VideoRepository;
import com.API.CodeLab.Services.VideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServicesImpl implements VideoServices {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoServicesImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> GetVideos() {
        return videoRepository.findAll();
    }

    @Override
    public String PostVideos(Video video) {
        videoRepository.save(video);
        return "Video posteado con exito!";
    }

    @Override
    public List<Video> DeleteVideos(Long id) {
        videoRepository.deleteById(id);
        return videoRepository.findAll();
    }

    @Override
    public List<Video> PutVideos(Video video , Long id) {
        Video video1 = videoRepository.findById(id).get();

        if(video1 != null){
            video1.setDescripcion(video.getDescripcion());
            video1.setImagen(video.getImagen());
            video1.setLink(video.getLink());
            video1.setSubtitulo(video.getSubtitulo());
            video1.setTitulo(video.getTitulo());
            videoRepository.save(video1);
            return videoRepository.findAll();

        } else {
            new Error("Hubo un error!");
            return null;
        }
    }
}
