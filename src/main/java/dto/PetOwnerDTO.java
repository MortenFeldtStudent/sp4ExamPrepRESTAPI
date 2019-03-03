package dto;

import entity.Pet;

public class PetOwnerDTO {
    
    private int id;
    private String name;
    private String birth;
    private String species;
    private String owner_fname;
    private String owner_lname;

    public PetOwnerDTO(Pet pet) {
        this.id = pet.getId();
        this.name = pet.getName();
        this.birth = String.valueOf(pet.getBirth());
        this.species = pet.getSpecies();
        this.owner_fname = pet.getOwnerId().getFirstName();
        this.owner_lname = pet.getOwnerId().getLastName();
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

    public String getOwner_fname() {
        return owner_fname;
    }

    public void setOwner_fname(String owner_fname) {
        this.owner_fname = owner_fname;
    }

    public String getOwner_lname() {
        return owner_lname;
    }

    public void setOwner_lname(String owner_lname) {
        this.owner_lname = owner_lname;
    }

    @Override
    public String toString() {
        return "PetOwnerDTO{" + "id=" + id + ", name=" + name + ", birth=" + birth + ", species=" + species + ", owner_fname=" + owner_fname + ", owner_lname=" + owner_lname + '}';
    }
    
    
}
