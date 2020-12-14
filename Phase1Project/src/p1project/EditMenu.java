package p1project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

public class EditMenu {

	public static void editFiles() {

		Scanner option = new Scanner(System.in);

		System.out.println("Options:");
		System.out.println("1. Add a file");
		System.out.println("2. Delete a file (case sensitive)");
		System.out.println("3. Search for a file (not case sensitive)");
		System.out.println("4. Back to main menu");
		System.out.println("Type the corresponding number and press Enter key: ");
		int choice = 0;
		do {
			try {
				choice = Integer.valueOf(option.next());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid Choice. Please Enter valid input: ");
			}
		} while (choice == 0);

		while (choice != 4) {
			if (choice == 1) {
				System.out.println("Enter name of the file you want to add: ");
				String fileName = option.next();
				addFile(fileName);
				choice = 0;
				continue;
			} else if (choice == 2) {
				System.out.println("Enter name of the file you want to delete: ");
				String fileName = option.next();
				deleteFile(fileName);
				choice = 0;
				continue;
			} else if (choice == 3) {
				System.out.println("Enter name of the file you want to search for: ");
				String fileName = option.next();
				searchFile(fileName);
				choice = 0;
				continue;
			} else if (choice == 0) {
				System.out.println("1. Add a file");
				System.out.println("2. Delete a file (case sensitive)");
				System.out.println("3. Search for a file (not case sensitive)");
				System.out.println("4. Back to main menu");

			} else {
				System.out.println("Invalid input. Please enter a number between 1 and 4");
			}
			System.out.println("Enter another option");
			do {
				try {
					choice = Integer.valueOf(option.next());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please Enter valid input: ");
				}
			} while (choice == 0);
		}
		toWelcomeMenu();
	}

	
	public static void addFile(String fileName) {
		File newFile = new File("./userFiles/" + fileName);  //
		try {
			if (newFile.createNewFile()) {
				System.out.println("File successfully created: " + fileName);
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			System.out.println("error occurred");
			e.printStackTrace();
		}

	}

	
	// It IS Case Sensitive
	public static void deleteFile(String fileName) {
		
		boolean fileFound = false;
		String[] allFileNames = (new File("./userFiles/").list());   //
		for (String name : allFileNames) {
			if (name.equals(fileName)) {
				fileFound = true;
			}
		}
		if (fileFound) {
			File file = new File("./userFiles/" + fileName);   //
			if (file.delete()) {
				System.out.println("File successfully deleted: " + fileName);
			} else {
				System.out.println("File not deleted");
			}
		} else {
			System.out.println("File Not Found!");
		}
	}

	// case doesn't matter
	public static void searchFile(String fileName) {
		System.out.println("Searching for  " + fileName);
		boolean fileFound = false;
		File projectDir = new File("./userFiles");    //
		String[] allFileNames = projectDir.list();
		fileName = fileName.toLowerCase();
		for (String name : allFileNames) {
			String compareName = name.toLowerCase();
			if (fileName.equals(compareName)) {
				System.out.println("File Found! " + name);
				fileFound = true;
				break;
			}
		}
		if (!fileFound) {
			System.out.println("File Not Found!");
		}
	}

	// works fine
	public static void toWelcomeMenu() {
		System.out.println("Exit to Main menu selected");
	}

}
