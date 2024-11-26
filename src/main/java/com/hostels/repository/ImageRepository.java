package com.hostels.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.hostels.model.ImageEntity;

public interface ImageRepository extends MongoRepository<ImageEntity, String> {
	
	Optional<ImageEntity> findByGuestId(String guestId);
	
}
