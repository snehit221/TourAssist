package com.group15.tourassist.service;

import com.group15.tourassist.repository.IActivityRepository;
import com.group15.tourassist.repository.IStayRepository;
import com.group15.tourassist.repository.ITourGuideRepository;
import com.group15.tourassist.repository.ITransportationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotalPackagePriceCalculatorService implements ITotalPackagePriceCalculatorService {

    private final ITransportationRepository transportationRepository;
    private final IStayRepository stayRepository;
    private final IActivityRepository activityRepository;
    private final ITourGuideRepository tourGuideRepository;
    Logger log = LoggerFactory.getLogger(TotalPackagePriceCalculatorService.class);

    @Autowired
    public TotalPackagePriceCalculatorService(ITransportationRepository transportationRepository, IStayRepository stayRepository, IActivityRepository activityRepository, ITourGuideRepository tourGuideRepository) {
        this.transportationRepository = transportationRepository;
        this.stayRepository = stayRepository;
        this.activityRepository = activityRepository;
        this.tourGuideRepository = tourGuideRepository;
    }

    /**
     * @param packageId id of the package
     * @return total price of the parent package id by adding all the sub categories
     */
    @Override
    public Double getTotalPackagePrice(Long packageId) {
        Double transportationPrice = transportationRepository.getTransportationDetailsByPackageId(packageId).getPrice();
        Double stayPrice = stayRepository.getStayDetailsByPackageId(packageId).getPrice();
        Double activityPrice = activityRepository.getActivityDetailsByPackageId(packageId).getPrice();
        Double tourGuidePrice = tourGuideRepository.getTourGuideByPackageId(packageId).getPrice();

        Double totalPackagePrice = transportationPrice + stayPrice + activityPrice + tourGuidePrice;

        log.info("Transportation Price: {}", transportationPrice);
        log.info("Stay Price: {}", stayPrice);
        log.info("Activity Price: {}", activityPrice);
        log.info("Tour Guide Price: {}", tourGuidePrice);
        log.info("Total Package Price: {}", totalPackagePrice);
        return totalPackagePrice;
    }
}
