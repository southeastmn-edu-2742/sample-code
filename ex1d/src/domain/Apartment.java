package domain;

import java.time.LocalDateTime;

public class Apartment {
    private int apartmentId;
    private String apartmentNum;
    private int squareFeet;
    private int bathrooms;
    private double price;
    private LocalDateTime updated;
    private Person administrator;
    private Person tenant;

    public Apartment() {
        this.apartmentId = 0;
        this.apartmentNum = "";
        this.squareFeet = 0;
        this.bathrooms = 0;
        this.price = 0.0;
        this.updated = LocalDateTime.now();
        this.administrator = null;
        this.tenant = null;
    }

//    public Apartment(int apartmentId, String location, String apartmentNum, int squareFeet, int bathrooms, double price) {
//        this.apartmentId = apartmentId;
//        this.apartmentNum = apartmentNum;
//        this.squareFeet = squareFeet;
//        this.bathrooms = bathrooms;
//        this.price = price;
//        this.updated = LocalDateTime.now();
//    }

    public int getApartmentId() {
        return apartmentId;
    }
    public String getApartmentNum() {
        return apartmentNum;
    }
    public int getSquareFeet() {
        return squareFeet;
    }
    public int getBathrooms() { return this.bathrooms; }
    public double getPrice() {
        return price;
    }
    public LocalDateTime getUpdated() {
        return updated;
    }
    public Person getAdministrator() { return administrator; }
    public Person getTenant() { return tenant; }

    public String setApartmentId(int apartmentId) {
        String errMsg = "";
        if (apartmentId >= 100 && apartmentId <= 199)
            this.apartmentId = apartmentId;
        else
            errMsg = Integer.toString(apartmentId) + " is invalid. ApartmentId must be >= 101 and <= 199";
        return errMsg;
    }

    public String setApartmentNum(String apartmentNum) {
        String errMsg = "";
        if (apartmentNum != null && apartmentNum.length() >= 1 && apartmentNum.length() <= 4)
            this.apartmentNum = apartmentNum;
        else
            errMsg = "ApartmentNum is required";
        return errMsg;
    }

    public String setSquareFeet(int squareFeet) {
        String errMsg = "";
        if (squareFeet >= 200 && squareFeet <= 2000)
            this.squareFeet = squareFeet;
        else
            errMsg = Integer.toString(squareFeet) + " is invalid. Square feet must be > 200 and < 2000.";
        return errMsg;
    }

    public String setBathrooms(int bathrooms) {
        String errMsg = "";
        if (bathrooms >= 1 && bathrooms <= 3)
            this.bathrooms = bathrooms;
        else
            errMsg = Integer.toString(bathrooms) + " is invalid. Bathrooms must be > 0 and < 4.";
        return errMsg;
    }

    public String setPrice(double price) {
        String errMsg = "";
        if (price > 99.99 && price < 9999.99)
            this.price = price;
        else
            errMsg = Double.toString(price) + " is invalid. Price must be > 99.99 and < 9999.99";
        return errMsg;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public void setAdministrator(Person administrator) {
        this.administrator = administrator;
    }

    public void setTenant(Person tenant) {
        this.tenant = tenant;
    }

    @Override
    public String toString() {
        return "Apartment:\n" +
                "\tApartment Id=\t" + this.apartmentId +
                "\n\tApartment#=\t\t" + this.apartmentNum +
                "\n\tSquare Feet=\t" + this.squareFeet +
                "\n\tBathrooms=\t\t" + this.bathrooms +
                "\n\tPrice=\t\t\t" + this.price +
                "\n\tUpdated=\t\t" + this.updated +
                "\n";
    }
}
