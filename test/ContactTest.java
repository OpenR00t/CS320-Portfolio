package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

    @Test
    void testContact() {
        Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
        assertTrue(contact.getContactID().equals("01"));
        assertTrue(contact.getFirstName().equals("Ryan"));
        assertTrue(contact.getLastName().equals("Laird"));
        assertTrue(contact.getPhoneNumber().equals("2512312691"));
        assertTrue(contact.getAddress().equals("Notre Dame, USA"));
    }

    @Test
    void testSetContact() {
        Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
        contact.setFirstName("Jim");
        contact.setLastName("Dim");
        contact.setPhoneNumber("3612312691");
        contact.setAddress("Phoenix, USA");
        assertTrue(contact.getFirstName().equals("Jim"));
        assertTrue(contact.getLastName().equals("Dim"));
        assertTrue(contact.getPhoneNumber().equals("3612312691"));
        assertTrue(contact.getAddress().equals("Phoenix, USA"));
    }

    //testing initial variable lengths
    @Test
    void testContactIDLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("00000000001", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
        });
    }

    @Test
    void testFirstNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", "Ryanxxxxxxx", "Laird", "2512312691", "Notre Dame, USA");
        });
    }

    @Test
    void testLastNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", "Ryan", "Lairdxxxxxx", "2512312691", "Notre Dame, USA");
        });
    }

    @Test
    void testPhoneNumberLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", "Ryan", "Laird", "251231269", "Notre Dame, USA");
        });
    }

    @Test
    void testAddressLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USAxxxxxxxxxxxxxxxx");
        });
    }


    //testing setter variable lengths
    @Test
    void testSetFirstNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setFirstName("Ryanxxxxxxx");
        });
    }
    @Test
    void testSetLastNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setLastName("Lairdxxxxxx");
        });
    }
    @Test
    void testSetPhoneNumberLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setPhoneNumber("251231269");
        });
    }
    @Test
    void testSetAddressLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setAddress("Notre Dame, USAxxxxxxxxxxxxxxxx");
        });
    }


    //testing if variable is null
    @Test
    void testContactIDNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Ryan", "Laird", "2512312691", "Notre Dame, USA");
        });
    }

    @Test
    void testFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", null, "Laird", "2512312691", "Notre Dame, USA");
        });
    }

    @Test
    void testLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", "Ryan", null, "2512312691", "Notre Dame, USA");
        });
    }

    @Test
    void testPhoneNumberNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", "Ryan", "Laird", null, "Notre Dame, USA");
        });
    }

    @Test
    void testAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("01", "Ryan", "Laird", "2512312691", null);
        });
    }

    
    //testing if setter variable is null
    @Test
    void testSetFirstNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setFirstName(null);
        });
    }
    @Test
    void testSetLastNameNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setLastName(null);
        });
    }
    @Test
    void testSetPhoneNumberNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setPhoneNumber(null);
        });
    }
    @Test
    void testSetAddressNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	Contact contact = new Contact("01", "Ryan", "Laird", "2512312691", "Notre Dame, USA");
            contact.setAddress(null);
        });
    }
}
