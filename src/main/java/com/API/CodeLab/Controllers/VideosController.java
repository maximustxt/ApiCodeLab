package com.API.CodeLab.Controllers;

import com.API.CodeLab.ExceptionCustom.ExceptionCustom;
import com.API.CodeLab.Models.Video;
import com.API.CodeLab.Services.VideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Videos")
public class VideosController {

    @Autowired
    private VideoServices videoServices;

    @GetMapping
    public ResponseEntity<List<Video>> GetVideo(){
        return ResponseEntity.ok(videoServices.GetVideos());
    }

    @PostMapping
    public ResponseEntity<String> PostVideo(@RequestBody Video video) {
        if (video.getDescripcion() == null || video.getImagen() == null || video.getLink() == null || video.getSubtitulo() == null || video.getTitulo() == null) {
            throw new ExceptionCustom("Faltan datos para crear un curso!");
        } else {
            return ResponseEntity.ok(videoServices.PostVideos(video));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Video>> DeleteVideo(@PathVariable Long id){
        if(id == null){
            throw new ExceptionCustom("No existe el video!");
        } else {
            return ResponseEntity.ok(videoServices.DeleteVideos(id));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Video>> PutVideo(@RequestBody Video video , @PathVariable Long id ) {
        if (id == null) {
            throw new ExceptionCustom("No existe el video!");
        } else if (video.getDescripcion() == null || video.getImagen() == null || video.getLink() == null || video.getSubtitulo() == null || video.getTitulo() == null) {
            throw new ExceptionCustom("Faltan datos para crear un curso!");
        } else {
            return ResponseEntity.ok(videoServices.PutVideos(video, id));
        }
    }
}
