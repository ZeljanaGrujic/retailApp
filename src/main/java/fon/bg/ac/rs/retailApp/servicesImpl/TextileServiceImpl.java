package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.Textile;
import fon.bg.ac.rs.retailApp.repositories.TextileRepository;
import fon.bg.ac.rs.retailApp.services.TextileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextileServiceImpl implements TextileService {

    @Autowired
    private TextileRepository textileRepository;

    @Override
    public List<Textile> getTextiles() {
        return textileRepository.findAll();
    }

    @Override
    public Textile saveTextile(Textile textile) {
        return textileRepository.save(textile);
    }

    @Override
    public Optional<Textile> findById(int id) {
        return textileRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        textileRepository.deleteById(id);
    }

    @Override
    public List<Textile> findByPurpose(String purpose) {
        return textileRepository.findByPurpose(purpose);
    }
}
