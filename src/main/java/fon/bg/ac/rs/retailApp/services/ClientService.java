package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    List<Client> getClients();

    Client saveClient(Client client);

    Optional<Client> findById(int id);

    void deleteById(int id);
}
