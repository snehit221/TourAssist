package com.group15.tourassist.repository;

import com.group15.tourassist.entity.TourGuide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITourGuideRepository extends JpaRepository<TourGuide, Long> {
}