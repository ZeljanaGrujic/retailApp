package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.Textile;

import java.util.List;
import java.util.Optional;

public interface TextileService {
    List<Textile> getTextiles();

    Textile saveTextile(Textile textile);

    Optional<Textile> findById(int id);

    void deleteById(int id);
}
