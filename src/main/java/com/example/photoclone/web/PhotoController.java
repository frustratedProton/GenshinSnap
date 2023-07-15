package com.example.photoclone.web;

import com.example.photoclone.model.Photo;
import com.example.photoclone.service.PhotosService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Collection;

@RestController
public class PhotoController {

    private final PhotosService photosService;

    public PhotoController(PhotosService photosService) {
        this.photosService = photosService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get() {
        return photosService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photosService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id) {
        photosService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photosService.save(file.getOriginalFilename(), file.getContentType() ,file.getBytes());
    }
}
