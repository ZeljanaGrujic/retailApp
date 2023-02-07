package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.TextileMake;
import fon.bg.ac.rs.retailApp.repositories.TextileMakeRepository;
import fon.bg.ac.rs.retailApp.repositories.TextileModelRepository;
import fon.bg.ac.rs.retailApp.services.TextileMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextileMakeServiceImpl implements TextileMakeService {

    @Autowired
    private TextileMakeRepository textileMakeRepository;

    @Override
    public List<TextileMake> getTextileMakes() {
        return textileMakeRepository.findAll();
    }

    @Override
    public TextileMake saveTextileMake(TextileMake textileMake) {
        return textileMakeRepository.save(textileMake);
    }

    @Override
    public Optional<TextileMake> findById(int id) {
        return textileMakeRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        textileMakeRepository.deleteById(id);
    }
}
