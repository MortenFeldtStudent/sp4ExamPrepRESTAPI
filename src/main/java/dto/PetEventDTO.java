package dto;

import entity.Pet;
import java.util.List;

public class PetEventDTO {
    
    private int id;
    private String name;
    private String birth;
    private String species;
    private String death;
    private List<String> events;

    public PetEventDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.birth = String.valueOf(pet.getBirth());
        this.species = pet.getSpecies();
        this.death = String.valueOf(pet.getDeath());
        this.events = pet.eventToString(pet.getEventCollection());
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    
    
}
