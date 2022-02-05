package models;

import java.util.Objects;

public class Car {

    private String brand;
    private String model;
    private String colour;
    private String year;
    private Long engineNumber;
    private String licensePlate;
    private int seatsNumber;
    private int warrantyYears;

    private String imageFilePathUrl;

//    Since the license plate and engine number are unique to only one car, there will only be a single owner
    private Owner owner;

    public Car(){

    }

    public Car(String brand, String model, String colour, String year, Long engineNumber, String licensePlate) {
        this.brand = brand;
        this.model = model;
        this.colour = colour;
        this.year = year;
        this.engineNumber = engineNumber;
        this.licensePlate = licensePlate;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }

    public void setWarrantyYears(int warrantyYears) {
        this.warrantyYears = warrantyYears;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(Long engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getImageFilePathUrl() {
        return imageFilePathUrl;
    }

    public void setImageFilePathUrl(String imageFilePathUrl) {
        this.imageFilePathUrl = imageFilePathUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return seatsNumber == car.seatsNumber && warrantyYears == car.warrantyYears && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(colour, car.colour) && Objects.equals(year, car.year) && Objects.equals(engineNumber, car.engineNumber) && Objects.equals(licensePlate, car.licensePlate) && Objects.equals(imageFilePathUrl, car.imageFilePathUrl) && Objects.equals(owner, car.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, colour, year, engineNumber, licensePlate, seatsNumber, warrantyYears, imageFilePathUrl, owner);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", year='" + year + '\'' +
                ", engineNumber=" + engineNumber +
                ", licensePlate='" + licensePlate + '\'' +
                ", seatsNumber=" + seatsNumber +
                ", warrantyYears=" + warrantyYears +
                ", imageFilePathUrl='" + imageFilePathUrl + '\'' +
                ", owner=" + owner +
                '}';
    }
}
