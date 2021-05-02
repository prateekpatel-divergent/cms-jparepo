package com.divergentsl.cmsjap;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cmsjap.entity.Patient;
import com.divergentsl.cmsjap.service.PatientService;

@Component
public class PatientData {

	@Autowired
	PatientService patientService;

	@Autowired
	private MainMenu mainMenu;

	private void printPatientOption() {
		System.out.println("\n--------------------Patient Menu--------------------");
		System.out.println("1. Add Patient");
		System.out.println("2. Search Patient");
		System.out.println("3. List All Patient");
		System.out.println("4. Delete Patient");
		System.out.println("5. Update Patient");
		System.out.println("6. Exit");
	}

	/**
	 * Select Option by this method
	 */
	public void patientPanel() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			printPatientOption();
			String input = sc.nextLine();
			switch (input) {
			case "1":
				insertData();
				break;
			case "2":
				searchData();
				break;
			case "3":
				listData();
				break;
			case "4":
				deleteData();
				break;
			case "5":
				updateData();
				break;
			case "6":
				mainMenu.startPanel();
				break;
			default:
				System.out.println("choose write option: ");
				break;
			}
		}
	}

	public void insertData() {

		Scanner sc = new Scanner(System.in);

		System.out.print("\nEnter Patient Name : ");
		String name = sc.nextLine();

		System.out.print("\nEnter Patient Age : ");
		int age = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Patient Weight : ");
		int weight = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Patient Gender : ");
		String gender = sc.nextLine();

		System.out.print("\nEnter Patient Contact Number : ");
		int contactNumber = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Patient Addrress : ");
		String address = sc.nextLine();

		patientService.add(name, age, weight, gender, contactNumber, address);
		System.out.println("\n Insert Succesfully");
	}

	public void deleteData() {

		System.out.println("\nEnter Patient Id :");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		if (this.patientService.remove(id)) {
			System.out.println("Record Deleted");
		} else {
			System.out.println("Record Not Found");
		}
	}

	public void searchData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Patient Id : ");
		int patientId = Integer.parseInt(sc.nextLine());

		Patient patient = patientService.searchById(patientId);

		if (patient != null) {
			System.out.println("\n------------------------------------Patient Data-----------------------------------");
			System.out.printf("| %2d | %12s | %6s | %3d | %6d | %14d | %10s |\n", patient.getId(), patient.getName(),
					patient.getGender(), patient.getAge(), patient.getWeight(), patient.getContactNumber(),
					patient.getAddress());
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\nPatient Data Not Found!");
		}
	}

	public void listData() {
		List<Patient> patientList = this.patientService.list();
		System.out.println("\n---------------------------------Patient List--------------------------------------");
		for (Patient patient : patientList) {
			System.out.printf("%2d | %12s | %6s | %3d | %6d | %14d | %10s |\n", patient.getId(), patient.getName(),
					patient.getGender(), patient.getAge(), patient.getWeight(), patient.getContactNumber(),
					patient.getAddress());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	public void updateData() {

	}
}
