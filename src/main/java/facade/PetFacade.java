package facade;

import dto.PetDTO;
import dto.PetEventDTO;
import dto.PetOwnerDTO;
import entity.Event;
import entity.Pet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PetFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    //Tasks
    //1. Implement a simple facade class with a method that will return all Pet’s, and demonstrate the method
    public List<PetEventDTO> getAllPetsEventDTO() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PetEventDTO(p) FROM Pet AS p");
        return query.getResultList();
    }

    //Tasks
    //2. Implement a Rest service to get the total Number of pets formatted like: {"petCount":4}
    //(just call size() on the result from the method above)
    public int getAllPetsCount() {
        return getAllPetsEventDTO().size();
    }

    //Tasks
    //3. Use the method from 1) to implement a REST service to get a json-list of all pets, with id, name, birth, species and the first_name and last_name of the owner
    public List<PetOwnerDTO> getAllPetsOwnerDTO() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PetOwnerDTO(p) FROM Pet AS p");
        return query.getResultList();
    }

    //Tasks - REST (EXTRA)
    //1. Get a list of all living pets.
    public List<PetDTO> getAllPetsLivingDTO() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PetDTO(p) FROM Pet AS p WHERE p.death = null");
        return query.getResultList();
    }

    //Tasks - REST (EXTRA)
    //2. Get a list of all pets that had an event on a given day.
    public List<PetDTO> getAllPetsEventsDate(Date date) {  
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT NEW dto.PetDTO(p) FROM Pet p JOIN p.eventCollection e WHERE e.date = :date");
        query.setParameter("date", date);
        return query.getResultList();
    }
    
    //Tasks - REST (EXTRA)
    //3. Create a new event for an existing pet.
    public Event createEventAndAddToPet(int petId, Event newEvent) {  
        EntityManager em = emf.createEntityManager();
        Pet pet = em.find(Pet.class, petId);
        PetDTO petDTO = new PetDTO(pet);
        Pet newPet = new Pet(petDTO.getId(), petDTO.getName(), petDTO.getSpecies());
        Date date = new Date();
        newPet.setBirth(pet.getBirth());
        newEvent.setPetId(newPet);
        newEvent.setDate(date);
        
        try {
            em.getTransaction().begin();
            em.persist(newEvent);
            em.getTransaction().commit();
            return newEvent;
        } finally {
            em.close();
        }
        
    }

}
