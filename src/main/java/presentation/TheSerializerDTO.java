package presentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PetEventDTO;
import facade.PetFacade;
import java.util.List;

/**
 * The purpose of TheSerializerDTO: !!!TYPE PURPOSE OF TheSerializerDTO HERE!!!
 * @author Morten
 * @version 1.0
 * @since 01-03-2019
 */

public class TheSerializerDTO {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final PetFacade pf = new PetFacade();

    public static void main(String[] args) {
//        DF.populate();
//        DF.getAllAddresses().forEach((el) -> System.out.println(el));
//        System.out.println(gson.toJson(DF.getAllAddresses()));  //Bad call
        
        //DF.populate();
        //List<Customer> allCustomers = DF.getAllCustomers();
        List<PetEventDTO> allPetsDTO = pf.getAllPetsEventDTO();
        //System.out.println(DF.getAllCustomersDTO().size());
        System.out.println(gson.toJson(allPetsDTO));
            
    }
    
}
