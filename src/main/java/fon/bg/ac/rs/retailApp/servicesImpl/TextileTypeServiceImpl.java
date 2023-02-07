package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.TextileType;
import fon.bg.ac.rs.retailApp.repositories.TextileRepository;
import fon.bg.ac.rs.retailApp.repositories.TextileTypeRepository;
import fon.bg.ac.rs.retailApp.services.TextileTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextileTypeServiceImpl implements TextileTypeService {
    @Autowired
    private TextileTypeRepository textileTypeRepository;

    @Override
    public List<TextileType> getTextileTypes() {
        return textileTypeRepository.findAll();
    }

    @Override
    public TextileType saveTextileType(TextileType textileType) {
        return textileTypeRepository.save(textileType);
    }

    @Override
    public Optional<TextileType> findById(int id) {
        return textileTypeRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {

        textileTypeRepository.deleteById(id);
    }
}
