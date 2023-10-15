package com.group15.tourassist.web.controller;

import com.group15.tourassist.entity.ResortMaster;
import com.group15.tourassist.service.IResortMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ResortMasterController {

    Logger log = LoggerFactory.getLogger(ResortMasterController.class);


    @Autowired
    private IResortMasterService resortMasterService;

    @GetMapping("/resorts/{destinationId}")
    private ResponseEntity<List<ResortMaster>> getResorts(@PathVariable Long destinationId) {
        log.info("** get resorts request");
        List<ResortMaster> resorts = resortMasterService.getAllResortsByDestinationId(destinationId);
        return ResponseEntity.of(Optional.of(resorts));
    }
}
