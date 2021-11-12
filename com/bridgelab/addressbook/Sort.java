package com.bridgelab.addressbook;

import java.util.Comparator;

public class Sort {
	static Comparator<ContactPerson> compareCity = new Comparator<ContactPerson>() {
        public int compare(ContactPerson one, ContactPerson two) {
            return one.getCity().compareTo(two.getCity());
        }
    };
}


