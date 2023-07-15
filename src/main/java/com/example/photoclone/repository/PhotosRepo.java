package com.example.photoclone.repository;

import com.example.photoclone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotosRepo extends CrudRepository<Photo, Integer> {

}
