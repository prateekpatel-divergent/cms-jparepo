package com.divergentsl.cmsjap;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cmsjap.entity.Drug;
import com.divergentsl.cmsjap.service.DrugService;

@Component
public class DrugData {

	@Autowired
	private DrugService drugService;

	@Autowired
	private MainMenu mainMenu;

	private void printDrugOption() {
		System.out.println("\n--------------------Drug Menu--------------------");
		System.out.println("1. Add Drug");
		System.out.println("2. Search Drug");
		System.out.println("3. List All Drug");
		System.out.println("4. Delete Drug");
		System.out.println("5. Update Drug");
		System.out.println("6. Exit");
	}

	/**
	 * Select Option by this method
	 */
	public void drugPanel() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			printDrugOption();
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

		System.out.print("\nEnter Drug Name : ");
		String name = sc.nextLine();

		System.out.print("\nEnter Drug Rate : ");
		int rate = Integer.parseInt(sc.nextLine());

		drugService.add(name, rate);
		System.out.println("\n Insert Succesfully");
	}

	public void deleteData() {

		System.out.println("\nEnter Drug Id :");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		if (this.drugService.remove(id)) {
			System.out.println("Record Deleted");
		} else {
			System.out.println("Record Not Found");
		}
	}

	public void searchData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Drug Id : ");
		int drugId = Integer.parseInt(sc.nextLine());

		Drug drug = drugService.searchById(drugId);

		if (drug != null) {
			System.out.println("\n------------------------------------Drug Data-----------------------------------");
			System.out.printf("| %2d | %12s | %6s |\n", drug.getId(), drug.getName(), drug.getRate());
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.println("\nRecord Found");
		} else {
			System.out.println("\nDrug Data Not Found!");
		}
	}

	public void listData() {
		List<Drug> drugList = this.drugService.list();
		System.out.println("\n---------------------------------Drug List--------------------------------------");
		for (Drug drug : drugList) {
			System.out.printf("%2d | %12s | %6s |\n", drug.getId(), drug.getName(), drug.getRate());
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}

	public void updateData() {

	}
}
