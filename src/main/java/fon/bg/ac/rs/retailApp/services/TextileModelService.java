package fon.bg.ac.rs.retailApp.services;

import fon.bg.ac.rs.retailApp.models.TextileModel;

import java.util.List;
import java.util.Optional;

public interface TextileModelService {
    List<TextileModel> getTextileModels();

    TextileModel saveTextileModel(TextileModel textileModel);

    Optional<TextileModel> findById(int id);

    void deleteById(int id);
}
