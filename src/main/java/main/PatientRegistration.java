package main;

import java.util.HashSet;
import java.util.Set;

public class PatientRegistration {

    private Set<Patient> patients;
    private int patientId = 1;

    public PatientRegistration() {
        patients = new HashSet<Patient>();
    }

    public int idGenerator() {
        return patients.isEmpty() ? patientId : patientId + 1;
    }

    public Patient createPatient(String name, int age, String gender, String contact) {
        return new Patient(idGenerator(), name, age, gender, contact);
    }

    public void registering(Patient patient) {
        patients.add(patient);
        System.out.println();
    }

}
