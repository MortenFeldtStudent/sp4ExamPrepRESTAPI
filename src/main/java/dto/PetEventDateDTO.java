package dto;

import entity.Pet;

public class PetEventDateDTO {
    
    private int id;
    private String name;
    private String birth;
    private String species;

    public PetEventDateDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.birth = String.valueOf(pet.getBirth());
        this.species = pet.getSpecies();
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

    @Override
    public String toString() {
        return "PetDTO{" + "id=" + id + ", name=" + name + ", birth=" + birth + ", species=" + species + '}';
    }
    
    
}
