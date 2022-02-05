package catalogs;

import models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarCatalogue {

    private final List<Car> carList = new ArrayList<>();

    public CarCatalogue() {
    }

    public CarCatalogue(Car car){
        carList.add(car);
    }

    public Car createCar(String brand, String model, String colour,int seatsNumber, String licensePlate, String year, Long engineNumber, String imageFilePathUrl, int warrantyYears ){

        Car car = new Car();

        car.setBrand(brand);
        car.setModel(model);
        car.setColour(colour);
        car.setSeatsNumber(seatsNumber);
        car.setLicensePlate(licensePlate);
        car.setYear(year);
        car.setWarrantyYears(warrantyYears);
        car.setEngineNumber(engineNumber);
        car.setImageFilePathUrl(imageFilePathUrl);

        carList.add(car);

        return car;

    }

    public void createCar(Car car){
        carList.add(car);
    }

    public List<Car> getAllCarsList(){
        return carList;
    }

    public Car searchCarFromList(Long engineNumber){
        for (Car c:carList){
            if(engineNumber.equals(c.getEngineNumber())){
                return c;
            }
        }
        return null;
    }


}
