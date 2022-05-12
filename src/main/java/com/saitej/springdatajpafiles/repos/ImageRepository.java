package com.saitej.springdatajpafiles.repos;

import com.saitej.springdatajpafiles.entities.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image,Long> {
}
