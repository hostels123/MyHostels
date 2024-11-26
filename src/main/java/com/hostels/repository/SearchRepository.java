package com.hostels.repository;

import java.util.List;

import com.hostels.model.Guest;

public interface SearchRepository {

    List<Guest> findByText(String text);

}
