package com.bridgelab.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
	private static Scanner scan = new Scanner(System.in);
    static ArrayList<ContactPerson> personList = new ArrayList<>();
    Map<String,ArrayList<ContactPerson>> addressBook = new HashMap<String, ArrayList<ContactPerson>>();

    public void addDetails() {
        ContactPerson person = new ContactPerson();
        var wrapper = new Object() {boolean flag=true;};
        System.out.print("\nEnter Existing Book name or New Book Name to add contact : ");
        String bookName  = scan.next();

        if(addressBook.containsKey(bookName)) {
            System.out.println("Contact will be added to existing '"+bookName+"' Book");
        } else {
            System.out.println("New Address Book Created with the Name '"+bookName+"'");
        }
        System.out.println("Enter the number of contacts you want to enter");
		int number = scan.nextInt();

		for (int i = 0; i < number; i++) {
			System.out.println("Enter the contact details of person ");

			System.out.print("\nEnter First name : ");
			String firstName=scan.next();
			person.setFirstName(firstName);

			System.out.print("Enter Last name : ");
			String lastName=scan.next();
			person.setLastName(lastName);


        // Ensuring there is no Duplicate Entry of the same Person in a Address Book
			try {
				personList.stream().filter(contactList -> contactList.getFirstName().equals(firstName)&&contactList.getLastName().equals(lastName)).forEach(contactList -> {
					System.out.println("Can not allow Duplicate Contact");
					addDetails();
					wrapper.flag = false;
				});
			} catch(Exception e) {
				System.out.println();
			}

			while(wrapper.flag) {

				System.out.print("Enter Address : ");
				person.setAddress(scan.next());

				System.out.print("Enter City name : ");
				person.setCity(scan.next());

				System.out.print("Enter State name : ");
				person.setState(scan.next());

				System.out.print("Enter ZIP Code : ");
				person.setZip(scan.nextInt());;

				System.out.print("Enter Phone Number : ");
				person.setPhonenumber(scan.nextLong());

				System.out.print("Enter E-Mail ID : ");
				person.setEmail(scan.next());

            // Adding the details into list
				personList.add(person);
				addressBook.put(bookName,personList);
				System.out.println("\nGiven Details are added into the Book");
				wrapper.flag = false;
			}
		}		
    }

}

