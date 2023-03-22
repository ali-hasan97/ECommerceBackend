package com.genspark.ECommerceFullStack.Controller;

import com.genspark.ECommerceFullStack.Entity.Listing;
import com.genspark.ECommerceFullStack.Service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.*;

@RestController
public class MyController {

    // autowired because ListingService class is being injected into MyController class
    @Autowired
    private ListingService listingService;
    @GetMapping("/")
    public String home() {
        return (
                "<HTML>" +
                    "<H1>Welcome to eCommerce Application</H1>" +
                    "<form th:action='@{/listings/save}'" +
                        "th:object='${listing}' method='post'" +
                        "enctype='multipart/form-data'>" +
                        "<div>" +

                        "<label>Photos: </label>" +
                        "<input type='file' name='image' accept='image/png, image/jpeg' />" +
                        "</div>" +
                    "</form>" +
                    "<img th:src='/@{${listing.photosImagePath}}'/>" +
                "</HTML>"
            );
    }

    @GetMapping("/listings")
    public List<Listing> getListings() {
        return this.listingService.getAllListing();
    }

    @GetMapping("/listings/{productID}")
    public Listing getListingByID(@PathVariable String productID) {
        return this.listingService.getListingByID(Integer.parseInt(productID));
    }

    @PostMapping("/listings")
    public Listing addListing(@RequestBody Listing listing, MultipartFile multipartFile) throws IOException {
        return this.listingService.addListing(listing, multipartFile);
    }

    @PutMapping("/listings")
    public Listing updateListing(@RequestBody Listing listing) {
        return this.listingService.updateListing(listing);
    }

    @DeleteMapping("/listings/{productID}")
    public String deleteListings(@PathVariable String productID) {
        return this.listingService.deleteListingByID(Integer.parseInt(productID));
    }
}
