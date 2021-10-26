package com.github.alexandre.citiesapi.countries.repository;

import com.github.alexandre.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
