package catalogs;

import models.Owner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OwnerCatalog {

    private final List<Owner> ownerList = new ArrayList<Owner>();

    public OwnerCatalog(){

    }

    public OwnerCatalog(Owner owner){
        ownerList.add(owner);
    }


    public Owner createOwner(String name, String emailAddress, Long licenseNumber, Long socialSecurityNumber, String address){

        Owner owner = new Owner();
        owner.setName(StringUtils.capitalize(name));
        owner.setEmailAddress(emailAddress);
        owner.setLicenceNumber(licenseNumber);
        owner.setSocialSecurityNumber(socialSecurityNumber);
        owner.setAddress(address);
        ownerList.add(owner);
        return owner;
    }

    public void addOwner(Owner owner){
        ownerList.add(owner);
    }


    public List<Owner> getAllOwnersList(){
        return ownerList;
    }


    public Owner searchOwner(String ownerName){
        List<Owner> ownerList = getAllOwnersList();
        for(Owner o: ownerList){
            if(ownerName.equals(o.getName())){
                return o;
            }
        }
        return null;
    }

}
