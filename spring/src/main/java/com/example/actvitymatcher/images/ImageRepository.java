package com.example.actvitymatcher.images;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository <Image, Integer> {
Image findImageByTitle (String title);
}
