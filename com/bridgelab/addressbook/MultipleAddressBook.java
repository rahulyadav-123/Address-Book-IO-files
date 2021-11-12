package com.bridgelab.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {
	Map<String, AddressBook> map = new HashMap<>();

    public void addAddressBook() {
        System.out.println("Enter Name of new Address Book: ");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.next();
        if (map.containsKey(bookName)) {
            System.out.println("Address book with this name exists, Enter new name.");
            addAddressBook();
        } else {
            AddressBook addressBook = new AddressBook();
            map.put(bookName, addressBook);
            System.out.println("press 1 if you want to add another book or press any key to exit.");
            int newBook = scanner.nextInt();
            if (newBook == 1) {
                addAddressBook();
            }
        }
    }

    public void addressBookFunctions() {
        System.out.println("Enter the name of Address book to add, edit or delete the contact.");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if (map.containsKey(bookName)) {
            map.get(bookName);
            System.out.println("Enter book is present choose the options below to do certain function");
               System.out.println("Enter\n 1. add Contact\n 2. edit contact\n 3. delete contact\n 4. print contact\n" +
            "5.To contact person by city\n 6.To contact person by state");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        map.get(bookName).addContact();
                        break;
                    case 2:
                        map.get(bookName).editContact();
                        break;
                    case 3:
                        map.get(bookName).deleteContact();
                        break;
                    case 4:
                        map.get(bookName).printContact();
                        break;
                    case 5:
                    	map.get(bookName).contactBycity();
                        break;
                    case 6:
                    	map.get(bookName).contactBystate();
                        break;
                    case 7:
                    	map.get(bookName).countList();
                        break;
                    default:
                        System.out.println("Entered choice is incorrect!.. please enter correct choice");
                        break;
                }
            }
        }

    public void deleteBook() {
        System.out.println("Enter the name of Address book to delete.");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.next();
        if (map.containsKey(bookName)) {
            map.remove(bookName);
        } else {
            System.out.println("No book found");
        }
    }

    public void printBook() {
        System.out.println("These are AddressBooks in present program.");
        for (Map.Entry<String, AddressBook> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "[]");
        }
    }

    public void printContactsInBook() {
        for (Map.Entry<String, AddressBook> entry : map.entrySet()) {
            System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
            System.out.println(entry.getValue().list);
        }
    }
    
    public void searchPersonByState(String stateName) {
        // search person by their State
        for (Map.Entry<String, AddressBook> entry : map.entrySet()) {
        	AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            value.getPersonNameByCity(stateName);
        }
    }

   public void searchPersonByCity() {
        // Search person by their  city
        for (Map.Entry<String, AddressBook> entry : map.entrySet()) {
        	AddressBook value = entry.getValue();
            System.out.println("The Address Book: " + entry.getKey());
            System.out.println(entry.getValue().list);
        }
    }
}
