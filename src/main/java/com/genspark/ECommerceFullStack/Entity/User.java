package com.genspark.ECommerceFullStack.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="tbl_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userID;
    private String email;
    private String username;
    private String password;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="user_listings",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="c_id"))
    private Set<Listing> listings;

    public User() {

    }

    public User(int userID, String email, String username, String password, Set<Listing> listings) {
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.password = password;
        this.listings = listings;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Listing> getListings() {
        return listings;
    }

    public void setListings(Set<Listing> listings) {
        this.listings = listings;
    }
}
