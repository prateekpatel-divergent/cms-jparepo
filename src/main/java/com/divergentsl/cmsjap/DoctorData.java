package com.divergentsl.cmsjap;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cmsjap.entity.Doctor;
import com.divergentsl.cmsjap.service.DoctorService;

@Component
public class DoctorData {

	@Autowired
	DoctorService doctorService;

	@Autowired
	private MainMenu mainMenu;

	private void printDoctorOption() {
		System.out.println("\n--------------------Doctor Menu--------------------");
		System.out.println("1. Add Doctor");
		System.out.println("2. Search Doctor");
		System.out.println("3. List All Doctor");
		System.out.println("4. Delete Doctor");
		System.out.println("5. Update Doctor");
		System.out.println("6. Exit");
	}

	/**
	 * Select Option by this method
	 */
	public void doctorPanel() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			printDoctorOption();
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

		System.out.print("\nEnter Doctor Name : ");
		String name = sc.nextLine();

		System.out.print("\nEnter Doctor Speciality : ");
		String speciality = sc.nextLine();

		System.out.print("\nEnter Doctor ContactNo : ");
		String contactNo = sc.nextLine();

		System.out.print("\nEnter Doctor Fee : ");
		int fee = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter Doctor Degree : ");
		String degree = sc.nextLine();

		doctorService.add(name, speciality, contactNo, fee, degree);
		System.out.println("\n Insert Succesfully");
	}

	public void deleteData() {

		System.out.println("\nEnter Doctor Id :");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		if (this.doctorService.remove(id)) {
			System.out.println("Record Deleted");
		} else {
			System.out.println("Record Not Found");
		}
	}

	public void searchData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Doctor Id : ");
		int doctorId = Integer.parseInt(sc.nextLine());

		Doctor doctor = doctorService.searchById(doctorId);

		if (doctor != null) {
			System.out.println("\n------------------------------------Doctor Data-----------------------------------");
			
			System.out.printf("| %2s | %12s | %20s | %12s | %6s | %10s |\n", doctor.getId(), doctor.getName(),
					doctor.getSpeciality(), doctor.getContactno(), doctor.getFee(), doctor.getDegree());
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\nDoctor Data Not Found!");
		}
	}

	public void listData() {
		List<Doctor> doctorList = this.doctorService.listAll();
		System.out.println("\n---------------------------------Doctor List--------------------------------------");
		for (Doctor doctor : doctorList) {
			System.out.printf("| %2s | %12s | %20s | %12s | %6s | %10s |\n", doctor.getId(), doctor.getName(),
					doctor.getSpeciality(), doctor.getContactno(), doctor.getFee(), doctor.getDegree());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	public void updateData() {

	}
}
