package com.divergentsl.cmsjap;


import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cmsjap.entity.LabTest;
import com.divergentsl.cmsjap.service.LabTestService;

@Component
public class LabTestData {

	@Autowired
	LabTestService labTestService;

	@Autowired
	private MainMenu mainMenu;

	private void printLabTestOption() {
		System.out.println("\n--------------------LabTest Menu--------------------");
		System.out.println("1. Add LabTest");
		System.out.println("2. Search LabTest");
		System.out.println("3. List All LabTest");
		System.out.println("4. Delete LabTest");
		System.out.println("5. Update LabTest");
		System.out.println("6. Exit");
	}

	/**
	 * Select Option by this method
	 */
	public void labTestPanel() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			printLabTestOption();
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
		
		System.out.print("\nEnter LabTest Name : ");
		String name = sc.nextLine();

		System.out.print("\nEnter LabTest Age : ");
		int age = Integer.parseInt(sc.nextLine());

		System.out.print("\nEnter LabTest Weight : ");
		int weight = Integer.parseInt(sc.nextLine());

		labTestService.add(name, age, weight);
		System.out.println("\n Insert Succesfully");
	}

	public void deleteData() {

		System.out.println("\nEnter LabTest Id :");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		if (this.labTestService.remove(id)) {
			System.out.println("Record Deleted");
		} else {
			System.out.println("Record Not Found");
		}
	}

	public void searchData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter LabTest Id : ");
		int labTestId = Integer.parseInt(sc.nextLine());

		LabTest labTest = labTestService.searchById(labTestId);

		if (labTest != null) {
			System.out.println("\n------------------------------------LabTest Data-----------------------------------");
			System.out.printf("%2d | %12s | %6s | %3d |\n", labTest.getId(), labTest.getTest(),
					labTest.getRate(), labTest.getPid());
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\nLabTest Data Not Found!");
		}
	}

	public void listData() {
		List<LabTest> labTestList = this.labTestService.list();
		System.out.println("\n---------------------------------LabTest List--------------------------------------");
		for (LabTest labTest : labTestList) {
			System.out.printf("%2d | %12s | %6s | %3d |\n", labTest.getId(), labTest.getTest(),
					labTest.getRate(), labTest.getPid());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	public void updateData() {

	}
}

