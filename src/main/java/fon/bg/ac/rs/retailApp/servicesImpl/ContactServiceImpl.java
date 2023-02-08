package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.Contact;
import fon.bg.ac.rs.retailApp.repositories.ContactRepository;
import fon.bg.ac.rs.retailApp.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Optional<Contact> findById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }
}
