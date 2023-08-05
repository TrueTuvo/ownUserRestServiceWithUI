package com.severyn.zabara.spring.ownuserrestservicewithui.controller;

import com.severyn.zabara.spring.ownuserrestservicewithui.exceptions.UserNotFoundException;
import com.severyn.zabara.spring.ownuserrestservicewithui.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buckets")
public class BucketController {

    @Autowired
    private BucketService bucketService;

    @GetMapping("/")
    public ResponseEntity getAllBuckets() {
        try {
            return ResponseEntity.ok(bucketService.getAllBuckets());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

    @GetMapping
    public ResponseEntity getBucket(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(bucketService.getBucketByUserId(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }
}
