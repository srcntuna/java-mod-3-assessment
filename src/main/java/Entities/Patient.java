package Entities;

public class Patient {
    private String name;

    private Ailment ailment;
    private int healthIndex;



    private String speciality;
    private boolean isHealed;

    public Patient(String name, Ailment ailment) {
        this.name = name;
        this.speciality = ailment.getSpeciality();
        this.ailment = ailment;
        this.healthIndex = ailment.getStartingHealthIndex();
        this.isHealed = false;
    }

    public String getName() {
        return name;
    }


    public Ailment getAilment() {
        return ailment;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void receiveTreatment(int points){
        if(this.healthIndex >= 100){
            System.out.println("The patient is healed already!");
            return;
        }
        this.healthIndex+=points;
        if(this.healthIndex >= 100){
            System.out.println("HealthIndex is over 100 now. No longer treatment required. The patient is healed!");
            this.isHealed = true;
        }

    }

    @Override
    public String toString() {
        return "Patient{" + "name='" + name + '\'' + ", ailment=" + ailment + ", healthIndex=" + healthIndex + ", isHealed=" + isHealed + '}';
    }
}