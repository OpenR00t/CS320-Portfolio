package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.ContactService;

public class ContactServiceTest {
    
    @Test
    void addContactTest() {
        ContactService service = new ContactService();
        service.newContact("Ryan", "Laird", "2512312691", "Notre Dame, USA");
        assertTrue(service.getContacts().get(0).getFirstName().equals("Ryan"));
        assertTrue(service.getContacts().get(0).getLastName().equals("Laird"));
        assertTrue(service.getContacts().get(0).getPhoneNumber().equals("2512312691"));
        assertTrue(service.getContacts().get(0).getAddress().equals("Notre Dame, USA"));
    }

    @Test
    void deleteContactTest() {
        ContactService service = new ContactService();
        service.newContact("Ryan", "Laird", "2512312691", "Notre Dame, USA");
        Assertions.assertThrows(Exception.class, () -> {
            service.deleteContact("01");
        });
        Assertions.assertAll( () -> {
            service.deleteContact(service.getContacts().get(0).getContactID());
        });
    }

    @Test
    void changeFirstNameTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact("Ryan", "Laird", "2512312691", "Notre Dame, USA");
        service.changeFirstName(service.getContacts().get(0).getContactID(), "Jim");
        assertEquals("Jim", service.getContacts().get(0).getFirstName());
        assertThrows(Exception.class, () -> {
            service.changeFirstName("01", "Jim");
        });
    }

    @Test
    void changeLastNameTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact("Ryan", "Laird", "2512312691", "Notre Dame, USA");
        service.changeLastName(service.getContacts().get(0).getContactID(), "Dim");
        assertEquals("Dim", service.getContacts().get(0).getLastName());
        assertThrows(Exception.class, () -> {
            service.changeLastName("01", "Dim");
        });
    }

    @Test
    void changePhoneNumberTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact("Ryan", "Laird", "2512312691", "Notre Dame, USA");
        service.changePhoneNumber(service.getContacts().get(0).getContactID(), "3612312691");
        assertEquals("3612312691", service.getContacts().get(0).getPhoneNumber());
        assertThrows(Exception.class, () -> {
            service.changePhoneNumber("01", "3612312691");
        });
    }

    @Test
    void changeAddressTest() throws Exception {
        ContactService service = new ContactService();
        service.newContact("Ryan", "Laird", "2512312691", "Notre Dame, USA");
        service.changeAddress(service.getContacts().get(0).getContactID(), "Phoenix, USA");
        assertEquals("Phoenix, USA", service.getContacts().get(0).getAddress());
        assertThrows(Exception.class, () -> {
            service.changeAddress("01", "Phoenix, USA");
        });
    }

}
