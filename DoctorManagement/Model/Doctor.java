package Model;

public class Doctor {
    private String codeDoctor;
    private String nameDoctor;
    private String specializationDoctor;
    private int availabilityDoctor;

    public Doctor(String codeDoctor, String nameDoctor, String specializationDoctor, int availabilityDoctor) {
        this.codeDoctor = codeDoctor;
        this.nameDoctor = nameDoctor;
        this.specializationDoctor = specializationDoctor;
        this.availabilityDoctor = availabilityDoctor;
    }
    public String getCodeDoctor() {
        return codeDoctor;
    }
    public void setCodeDoctor(String codeDoctor) {
        this.codeDoctor = codeDoctor;
    }
    public String getNameDoctor() {
        return nameDoctor;
    }
    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }
    public String getSpecializationDoctor() {
        return specializationDoctor;
    }
    public void setSpecializationDoctor(String specializationDoctor) {
        this.specializationDoctor = specializationDoctor;
    }
    public int getAvailabilityDoctor() {
        return availabilityDoctor;
    }
    public void setAvailabilityDoctor(int availabilityDoctor) {
        this.availabilityDoctor = availabilityDoctor;
    }
    @Override
    public String toString() {
        return "Doctor [codeDoctor=" + codeDoctor + ", nameDoctor=" + nameDoctor + ", specializationDoctor="
                + specializationDoctor + ", availabilityDoctor=" + availabilityDoctor + "]";
    }

    

}
