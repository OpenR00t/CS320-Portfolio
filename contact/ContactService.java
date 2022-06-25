package contact;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
    private String uniqueID;
    private List<Contact> contacts = new ArrayList<>();

    public void newContact(String firstName, String lastName, String phoneNumber, String address) {
        Contact contact = new Contact(newUniqueID(), firstName, lastName, phoneNumber, address);
        contacts.add(contact);

    }

    public void deleteContact(String id) throws Exception {
        contacts.remove(contactSearch(id));
    }

    public void changeFirstName(String id, String firstName) throws Exception {
        contactSearch(id).setFirstName(firstName);
    }

    public void changeLastName(String id, String lastName) throws Exception {
        contactSearch(id).setLastName(lastName);
    }

    public void changePhoneNumber(String id, String phoneNumber) throws Exception {
        contactSearch(id).setPhoneNumber(phoneNumber);
    }

    public void changeAddress(String id, String address) throws Exception {
        contactSearch(id).setAddress(address);
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    private String newUniqueID() {
        return uniqueID = UUID.randomUUID().toString().substring(
            0, Math.min(toString().length(), 10));
    }

    private Contact contactSearch(String id) throws Exception {
        int index = 0;
        while (index < contacts.size()) {
            if (id.equals(contacts.get(index).getContactID())) {
                return contacts.get(index);
            }
            index++;
        }
        throw new Exception("The id could not be found");
    }
}