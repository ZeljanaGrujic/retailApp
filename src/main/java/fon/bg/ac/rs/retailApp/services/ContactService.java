package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    List<Contact> getContacts();

    Contact saveContact(Contact contact);

    Optional<Contact> findById(int id);

    void deleteById(int id);
}
