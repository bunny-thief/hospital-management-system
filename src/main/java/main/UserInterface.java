package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {

	private Scanner scanner = new Scanner(System.in);
	private PatientRegistration patientRegistration = new PatientRegistration();
	private List<Appointment> appointments = new ArrayList<>();

	public void makeAppointment(String name, Doctor doctor) {

		Set<Patient> arr = patientRegistration.getPatients();

		Patient patient = arr.stream().filter(n -> n.getName().equalsIgnoreCase(name)).findFirst().orElse(null);

		if (patient == null) {
			System.out.println("Patient not found!");
		} else {
			Appointment appointment = new Appointment(doctor, patient);
			appointments.add(appointment);
			System.out.println(appointment.toString());
		}
	}

	public Doctor createDoctor(String name) {
		return new Doctor(name);
	}

	public void userInteface() {

		int option = 0;
		do {

			System.out.println("1. Patient registration\n2. Appointment scheduling\n3. View information\n4. Exit");

			option = scanner.nextInt();

			switch (option) {
			case 1 -> {
				System.out.println("Enter name:");
				String name = scanner.nextLine();

				System.out.println("Enter age:");
				int age = scanner.nextInt();

				System.out.println("Enter gender:");
				String gender = scanner.nextLine();

				System.out.println("Enter contact:");
				String contact = scanner.nextLine();

				Patient patient = patientRegistration.createPatient(name, age, gender, contact);

				patientRegistration.registering(patient);
			}

			case 2 -> {
				System.out.println("Enter patient name:");
				String patientName = scanner.nextLine();

				System.out.println("Enter doctor name:");
				String doctorName = scanner.nextLine();

				makeAppointment(patientName, createDoctor(doctorName));
			}

			case 3 -> patientRegistration.getPatients().forEach(System.out::println);

			default -> throw new IllegalArgumentException("Unexpected value: " + option);
			}
		} while (option != 4);

	}

}
