package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.PetDTO;
import dto.PetEventDTO;
import dto.PetOwnerDTO;
import entity.Event;
import facade.PetFacade;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Morten
 */
@Path("pet")
public class PetResource {

    @Context
    private UriInfo context;
    //private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    private final PetFacade petFacade = new PetFacade();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of PetResource
     */
    public PetResource() {
    }

    //Tasks
    //1. Implement a simple facade class with a method that will return all Pet’s, and demonstrate the method
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPets() {
        List<PetEventDTO> petList = petFacade.getAllPetsEventDTO();
        return Response.ok().entity(gson.toJson(petList)).build();
    }

    //Tasks
    //2. Implement a Rest service to get the total Number of pets formatted like: {"petCount":4}
    //(just call size() on the result from the method above)
    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountPets() {
        String countPets = "{petCount:" + petFacade.getAllPetsCount() + "}";
        return Response.ok().entity(gson.toJson(countPets)).build();
    }

    //Tasks
    //3. Use the method from 1) to implement a REST service to get a json-list of all pets, with id, name, birth, species and the first_name and last_name of the owner
    @GET
    @Path("/all/owner")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPetsOwner() {
        List<PetOwnerDTO> petList = petFacade.getAllPetsOwnerDTO();
        return Response.ok().entity(gson.toJson(petList)).build();
    }

    //Tasks - REST (EXTRA)
    //1. Get a list of all living pets.
    @GET
    @Path("/living")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPetsLiving() {
        List<PetDTO> petList = petFacade.getAllPetsLivingDTO();
        return Response.ok().entity(gson.toJson(petList)).build();
    }

    //Tasks - REST (EXTRA)
    //2. Get a list of all pets that had an event on a given day.
    @GET
    @Path("/eventdate")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPetsEventDate(@QueryParam("date") String dateInput) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateInput);
        List<PetDTO> petList = petFacade.getAllPetsEventsDate(date);
        return Response.ok().entity(gson.toJson(petList)).build();
    }

    //Tasks - REST (EXTRA)
    //3. Create a new event for an existing pet.
    @POST
    @Path("/event/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postEventAddToPet(String content, @QueryParam("petid") int petId) {
        Event newEvent = petFacade.createEventAndAddToPet(petId, gson.fromJson(content, Event.class));
        return Response.ok().entity(gson.toJson(newEvent)).build();
    }
}
