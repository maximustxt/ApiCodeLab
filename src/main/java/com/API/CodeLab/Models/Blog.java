package com.API.CodeLab.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> imagenesDetail;
    private String titulo;
    private String subtitulo;
    private String descripcion;
    private String imagen;

    public Blog() {
    }

    public Blog(Long id, List<String> imagenesDetail, String titulo, String subtitulo, String descripcion, String imagen) {
        this.id = id;
        this.imagenesDetail = imagenesDetail;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getImagenesDetail() {
        return imagenesDetail;
    }

    public void setImagenesDetail(List<String> imagenesDetail) {
        this.imagenesDetail = imagenesDetail;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
