// Airliner and crew members is a Aggregation Relation.

public class Airliner {

    private ArrayList<CrewMember> crew;

    public Airliner() {
        this.crew = new ArrayList<CrewMember> ();
    }

    public void add(CrewMember crewMember){...}

}

// This means an Airliner can have 0 or more crew members

// Aggregation between PetStore and Pet
// Pet store is an aggregation of Pets, it can have 0 or more pets
// This is a weak "has-a" relationship 

public class PetStore {

    private ArrayList<PetObject> pets;

    public PetStore() {
        this.pets = new ArrayList<PetObject> ();
    }

    public voic add(PetObject petName) {...}

}