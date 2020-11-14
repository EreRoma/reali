package com.reali.service;

import com.reali.dto.*;
import com.reali.enumiration.Type;
import com.reali.model.ListingDetails;
import com.reali.repository.ListingRepository;
import com.reali.utils.ReaderUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ListingService implements Ilisting, InitializingBean {

    private final String MIN_PRICE_PARAM = "min_price";
    private final String MAX_PRICE_PARAM = "max_price";
    private final String MIN_BED_PARAM = "min_bed";
    private final String MAX_BED_PARAM = "max_bed";
    private final String MIN_BATH_PARAM = "min_bath";
    private final String MAX_BATH_PARAM = "max_bath";

    @Value("${listing.details}")
    private String listingDetails;

    @Autowired
    ListingRepository listingRepository;


    @Override
    public void afterPropertiesSet() throws Exception {
        listingRepository.saveAll(ReaderUtil.readCsv(listingDetails, ListingDetails.class));
    }

    @Override
    public GeoJson filterListings(Map<String, String> requestParams) {
        final RequestParams params = getRequestParams(requestParams);
        final List<ListingDetails> detailsList = listingRepository.filter(params.getMinPrice(), params.getMaxPrice(), params.getMinBed(), params.getMaxBed(),
                params.getMinBath(), params.getMaxBath());
        return gsonBuilder(detailsList);
    }

    private GeoJson gsonBuilder(List<ListingDetails> detailsList) {
        List<Feature> propertiesList = detailsList.stream()
                .map(Feature::new)
                .collect(Collectors.toList());
        return new GeoJson(Type.FEATURE_COLLECTION.getLabel(), propertiesList);
    }

    private RequestParams getRequestParams(Map<String, String> requestParams) {
        return RequestParams.builder()
                .minPrice(ReaderUtil.parseParam(MIN_PRICE_PARAM, requestParams))
                .maxPrice(ReaderUtil.parseParam(MAX_PRICE_PARAM, requestParams))
                .minBed(ReaderUtil.parseParam(MIN_BED_PARAM, requestParams))
                .maxBed(ReaderUtil.parseParam(MAX_BED_PARAM, requestParams))
                .minBath(ReaderUtil.parseParam(MIN_BATH_PARAM, requestParams))
                .maxBath(ReaderUtil.parseParam(MAX_BATH_PARAM, requestParams))
                .build();
    }
}
