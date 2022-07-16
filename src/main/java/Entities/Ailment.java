package Entities;

public class Ailment {


    private int startingHealthIndex;

    private String name;

    private String speciality;

    public Ailment(){

    }

    public Ailment(int startingHealthIndex, String name, String speciality) {
        this.startingHealthIndex = startingHealthIndex;
        this.name = name;
        this.speciality = speciality;
    }

    public int getStartingHealthIndex() {
        return startingHealthIndex;
    }

    public void setStartingHealthIndex(int startingHealthIndex) {
        this.startingHealthIndex = startingHealthIndex;
    }

    public String getSpeciality() {
        return speciality;
    }

    public String getName() {
        return name;
    }


}
