package com.genspark.ECommerceFullStack.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_listings")
public class Listing {

    @Id
    @Column(name="c_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productID;

    @Column(name="c_name")
    private String name;

    @Column(name="c_price")
    private int price;

    @Column(name="c_description")
    private String description;

    @Column(name="c_image", nullable = true, length = 64)
    private String image;

    @Transient
    public String getPhotosImagePath() {
        if (image == null || productID == 0) return null;

        return "/listingPhotos/" + productID + "/" + image;
    }

    public Listing() {
    }

    public Listing(String name, int price, String description, String image) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
