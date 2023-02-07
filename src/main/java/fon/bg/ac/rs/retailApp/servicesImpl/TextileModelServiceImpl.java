package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.TextileModel;
import fon.bg.ac.rs.retailApp.repositories.TextileModelRepository;
import fon.bg.ac.rs.retailApp.repositories.TextileTypeRepository;
import fon.bg.ac.rs.retailApp.services.TextileModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextileModelServiceImpl implements TextileModelService {

    @Autowired
    private TextileModelRepository textileModelRepository;

    @Override
    public List<TextileModel> getTextileModels() {
        return textileModelRepository.findAll();
    }

    @Override
    public TextileModel saveTextileModel(TextileModel textileModel) {
        return textileModelRepository.save(textileModel);
    }

    @Override
    public Optional<TextileModel> findById(int id) {
        return textileModelRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        textileModelRepository.deleteById(id);
    }
}
