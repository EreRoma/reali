package com.reali.repository;

import com.reali.model.ListingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ListingRepository extends JpaRepository<ListingDetails, Integer> {

    @Query(value = "select * from listings li \n" +
            "where ?1<= li.price and  li.price <=?2\n" +
            "and ?3<=li.bedrooms and li.bedrooms<=?4\n" +
            "and ?5<=li.bathrooms and li.bathrooms<=?6", nativeQuery = true)
    List<ListingDetails> filter(Integer miPrice, Integer maxPrice, Integer minBedrooms, Integer maxBedrooms, Integer minBathrooms, Integer maxBathrooms);
}
