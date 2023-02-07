package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.TextileType;

import java.util.List;
import java.util.Optional;

public interface TextileTypeService {
    List<TextileType> getTextileTypes();

    TextileType saveTextileType(TextileType textileType);

    Optional<TextileType> findById(int id);

    void deleteById(int id);
}
