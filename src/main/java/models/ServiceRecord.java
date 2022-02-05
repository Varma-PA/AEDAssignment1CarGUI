package models;

import java.util.Objects;

public class ServiceRecord {


    private Car car;
    private String time;
    private String description;

    public ServiceRecord(){

    }
    public ServiceRecord(Car car, String time, String description) {
        this.car = car;
        this.time = time;
        this.description = description;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceRecord that = (ServiceRecord) o;
        return Objects.equals(car, that.car) && Objects.equals(time, that.time) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, time, description);
    }

    @Override
    public String toString() {
        return "ServiceRecords{" +
                "car=" + car +
                ", time='" + time + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
