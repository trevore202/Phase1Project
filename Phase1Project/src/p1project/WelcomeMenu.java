package p1project;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class WelcomeMenu {

	public static void main(String[] args) {
		//create directory to store all these files if its not already been created.
		(new File("./userFiles")).mkdir();
		
		Scanner input = new Scanner(System.in);
		int choice = 0;
		// Display welcome and user's options

		System.out.println("Welcome to the Company Lockers Pvt. Ltd. LockedMe application");
		System.out.println("Developed by Trevor Evans");
		System.out.println("User Options: (Type the corresponding number and press Enter key)");
		System.out.println("1. See all files");
		System.out.println("2. Add, delete, or search files");
		System.out.println("3. Close application");
		do {
			try {
				choice = Integer.valueOf(input.next());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Choice. Please Enter valid input: ");
			}
		} while (choice == 0);

		// based on user input, call the corresponding method
		while (choice != 3) {
			if (choice == 1) {
				retrieveFiles();
				choice = 0;
			} else if (choice == 2) {
				toEditMenu();
				choice = 0;
			} else if (choice == 0) {
				System.out.println("\n\n1. See all files");
				System.out.println("2. Add, delete, or search files");
				System.out.println("3. Close application");
				do {
					try {
						choice = Integer.valueOf(input.next());
						break; // test if this breaks out of everything or just the inner do while loop
					} catch (NumberFormatException e) {
						System.out.println("Invalid Choice. Please Enter valid input: ");
					}
				} while (choice == 0);

			} else {
				System.out.println("Invlaid Choice. Please enter a valid input: ");
				choice = 0;
			}

		}

		if (choice == 3) {
			input.close();
			closeApplication();
		}
	}

	public static void retrieveFiles() {
		File projectDir = new File("./userFiles");
		File[] allFiles = projectDir.listFiles();
		if (allFiles.length == 0) {
			System.out.println("\nNo files currently exist!");
			return;
		}
		
		Arrays.sort(allFiles);
		//creates an array list that can be sorted
		ArrayList<File> allFilesList = new ArrayList<>();
		for(File f: allFiles) {
			allFilesList.add(f);
		}
		Collections.sort(allFilesList, new FileNameComparator());
		System.out.println("All Files:\n");
		for (File f : allFilesList) {
			System.out.println(f.getName());
		}
	}

	public static void toEditMenu() {
		System.out.println("Edit menu selected");
		new EditMenu().editFiles();
	}

	public static void closeApplication() {
		System.out.println("application closed");
	}
}