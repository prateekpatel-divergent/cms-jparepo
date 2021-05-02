package com.divergentsl.cmsjap;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mainMenu")
public class MainMenu {

	private static Logger logger = LoggerFactory.getLogger(MainMenu.class);
	
	@Autowired (required = true)
	private PatientData patientData;

	@Autowired (required = true)
	private DoctorData doctorData;
	
	@Autowired
	private DrugData drugData;
	
	@Autowired
	private LabTestData labTestData;

	public void startPanel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n----Admin Panel-----");
		System.out.println(
				"1.  Patient \n  2.  Doctor \n  3. 	Drug \n  4.	Lab Test \n  5. 	Book appointment for a patient by selecting Patient, Doctor and Data/time \n  6. 	Logout");
		System.out.println("Enter Your Choice: ");

		String input = sc.nextLine();

		switch (input) {
		case "1":
			patientData.patientPanel();
			break;
		case "2":
			doctorData.doctorPanel();
			break;
		case "3":
			drugData.drugPanel();
			break;
		case "4":
			labTestData.labTestPanel();
			break;
		case "5":

			break;
		case "6":
			logger.info("Exit");
			System.exit(0);
			break;
		}
	}

}
