package catalogs;

import models.ServiceRecord;

import java.util.ArrayList;
import java.util.List;

public class ServiceCatalog {

    private final List<ServiceRecord> serviceRecordList = new ArrayList<>();

    public ServiceCatalog(){

    }

    public ServiceCatalog(ServiceRecord serviceRecord){
        serviceRecordList.add(serviceRecord);
    }

    public void addServiceRecordLabel(ServiceRecord serviceRecord){
        serviceRecordList.add(serviceRecord);
    }

    public ServiceRecord getServicesForCar(Long engineNumber){
        for(ServiceRecord sr: serviceRecordList){
            if(engineNumber.equals(sr.getCar().getEngineNumber())){
                return sr;
            }
        }
        return null;
    }

    public List<ServiceRecord> getAllServiceRecords(){
        return serviceRecordList;
    }

}
