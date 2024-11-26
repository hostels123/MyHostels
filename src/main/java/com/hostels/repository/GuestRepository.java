package com.hostels.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hostels.model.Guest;

public interface GuestRepository extends MongoRepository<Guest,String> {

	@Query(value= "{'guestId' : ?0}")
	Optional<Guest> findByGuestId(int guestId);
	
}
