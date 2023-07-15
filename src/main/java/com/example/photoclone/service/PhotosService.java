package com.example.photoclone.service;

import com.example.photoclone.model.Photo;
import com.example.photoclone.repository.PhotosRepo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PhotosService {

    private final PhotosRepo photosRepo;

    public PhotosService(PhotosRepo photosRepo) {
        this.photosRepo = photosRepo;
    }

    public Iterable<Photo> get() {
        return photosRepo.findAll();
    }

    public Photo get(Integer id) {
        return photosRepo.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photosRepo.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photosRepo.save(photo);
        return photo;
    }
}
