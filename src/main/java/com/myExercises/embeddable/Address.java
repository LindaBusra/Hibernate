package com.myExercises.embeddable;

import javax.persistence.Embeddable;

@Embeddable// we can embed this class in our different entities
public class Address {

    private String city;
    private String country;
    private String zipCode;


    //Constructor
    public Address(){

    }



    //getter-setter

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }



    //toString()

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
