package com.reali.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "listings")
public class ListingDetails {
    @CsvBindByName(column = "id")
    @Column(name = "id")
    @Id
    private Integer id;
    @CsvBindByName(column = "street")
    @Column(name = "street")
    private String street;
    @CsvBindByName(column = "status")
    @Column(name = "status")
    private String status;
    @CsvBindByName(column = "price")
    @Column(name = "price")
    private Integer price;
    @CsvBindByName(column = "bedrooms")
    @Column(name = "bedrooms")
    private Integer bedrooms;
    @CsvBindByName(column = "bathrooms")
    @Column(name = "bathrooms")
    private Integer bathrooms;
    @CsvBindByName(column = "lat")
    @Column(name = "lat")
    private Double lat;
    @CsvBindByName(column = "lng")
    @Column(name = "lng")
    private Double lng;
}
