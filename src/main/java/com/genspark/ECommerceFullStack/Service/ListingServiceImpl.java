package com.genspark.ECommerceFullStack.Service;

import com.genspark.ECommerceFullStack.Dao.ListingDao;
import com.genspark.ECommerceFullStack.Entity.Listing;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ListingServiceImpl implements ListingService {
    @Autowired
    private ListingDao listingDao;

    @Override
    public List<Listing> getAllListing() {
        return this.listingDao.findAll();
    }

    @Override
    public Listing getListingByID(int productID) {
        Optional <Listing> c = this.listingDao.findById(productID);
        Listing listing = null;
        if (c.isPresent()) {
            listing = c.get();
        } else {
            throw new RuntimeException(" Listing not found for id :: " + productID);
        }
        return listing;
    }

    @Override
    public Listing addListing(Listing listing,
                              @RequestParam("image")MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        listing.setImage(fileName);
        Listing savedListing = listingDao.save(listing);
        String uploadDir = "listingPhotos/" + savedListing.getProductID();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return this.listingDao.save(listing);
    }

    @Override
    public Listing updateListing(Listing listing) {
        return this.listingDao.save(listing);
    }

    public String deleteListingByID(int productID) {
        this.listingDao.deleteById(productID);
        return "Deleted Successfully";
    }
}
