package com.bridgelab.addressbook;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {
		
		System.out.println("Welcome to AddressBook Mangament System");
		Scanner sc = new Scanner(System.in);
		AddressBook addressBook = new AddressBook();
		while (true) {
			System.out.println("Enter \n 1 To add The contact \n 2 To edit the contact \n 3 To delete the contact \n 4 to exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addressBook.addContact();
                    break;
                case 2:
                    addressBook.editContact();
                    break;
                case 3:
                    addressBook.deleteContact();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    continue;
            }
		}
	}
}


