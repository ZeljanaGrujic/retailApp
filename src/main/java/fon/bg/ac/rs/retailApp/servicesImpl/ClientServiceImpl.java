package fon.bg.ac.rs.retailApp.servicesImpl;


import fon.bg.ac.rs.retailApp.models.Client;
import fon.bg.ac.rs.retailApp.repositories.ClientRepository;
import fon.bg.ac.rs.retailApp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }
}
