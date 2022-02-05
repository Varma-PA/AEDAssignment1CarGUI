package models;

import java.util.List;
import java.util.Objects;

public class Owner {

    private String name;
    private List<Long> telephoneNumbers;
    private String emailAddress;
    private Long licenceNumber;
    private Long socialSecurityNumber;
    private String address;



//    Owner can own multiple cars list
    private List<Car> carsList;

    public Owner(){

    }

    public Owner(String name, List<Long> telephoneNumbers, String emailAddress, Long licenceNumber, Long socialSecurityNumber) {
        this.name = name;
        this.telephoneNumbers = telephoneNumbers;
        this.emailAddress = emailAddress;
        this.licenceNumber = licenceNumber;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getTelephoneNumbers() {
        return telephoneNumbers;
    }

    public void setTelephoneNumbers(List<Long> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(Long licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public Long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Car> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<Car> carsList) {
        this.carsList = carsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(name, owner.name) && Objects.equals(telephoneNumbers, owner.telephoneNumbers) && Objects.equals(emailAddress, owner.emailAddress) && Objects.equals(licenceNumber, owner.licenceNumber) && Objects.equals(socialSecurityNumber, owner.socialSecurityNumber) && Objects.equals(address, owner.address) && Objects.equals(carsList, owner.carsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, telephoneNumbers, emailAddress, licenceNumber, socialSecurityNumber, address, carsList);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", telephoneNumbers=" + telephoneNumbers +
                ", emailAddress='" + emailAddress + '\'' +
                ", licenceNumber=" + licenceNumber +
                ", socialSecurityNumber=" + socialSecurityNumber +
                ", address='" + address + '\'' +
                ", carsList=" + carsList +
                '}';
    }
}
