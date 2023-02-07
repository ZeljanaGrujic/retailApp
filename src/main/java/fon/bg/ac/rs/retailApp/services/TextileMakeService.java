package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.TextileMake;

import java.util.List;
import java.util.Optional;

public interface TextileMakeService {
    List<TextileMake> getTextileMakes();

    TextileMake saveTextileMake(TextileMake textileMake);

    Optional<TextileMake> findById(int id);

    void deleteById(int id);
}
