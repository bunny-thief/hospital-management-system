package main;

import java.util.Scanner;

public class UserInterface {

	private Scanner scanner = new Scanner(System.in);
	private PatientRegistration patientRegistration = new PatientRegistration();

	public void userInteface() {

		int option = 0;
		do {

			System.out.println("1. Patient registration\n2. Appointment scheduling\n3.View information\n4. Exit");

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

			case 2 -> System.out.println("Appointment");

			case 3 -> System.out.println("Display info");

			default -> throw new IllegalArgumentException("Unexpected value: " + option);
			}
		} while (option != 0);

	}

}
