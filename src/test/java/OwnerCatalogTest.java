import catalogs.OwnerCatalog;
import models.Owner;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class OwnerCatalogTest {


    @Test
    public void testJunit(){
        assertEquals(1, 1);
    }

    @Test
    public void testOwnerCreation() throws Exception {
        Owner owner = new Owner();
        owner.setName("Achyuth Varma");
        owner.setAddress("Boston");

        OwnerCatalog ownerCatalog = new OwnerCatalog();
        ownerCatalog.addOwner(owner);

        List<Owner> theOwnersList = ownerCatalog.getAllOwnersList();

        System.out.println(theOwnersList.get(0).getName());
        assertEquals("Achyuth Varma", theOwnersList.get(0).getName());

    }


}
