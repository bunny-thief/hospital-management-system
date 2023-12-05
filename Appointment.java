public class Appointment {
    private Doctor doctor;
    private Patient patient;

    public Appointment(Doctor doctor, Patient patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    @Override
    public String toString() {
        return String.format("%s has an appointment with %s", patient.getName(), doctor.getName());
    }
    
}
