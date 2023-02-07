package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.models.TextileStatus;
import fon.bg.ac.rs.retailApp.repositories.TextileStatusRepository;
import fon.bg.ac.rs.retailApp.services.TextileStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TextileStatusServiceImpl implements TextileStatusService {

    @Autowired
    private TextileStatusRepository textileStatusRepository;

    @Override
    public List<TextileStatus> getTextileStatuses() {
        return textileStatusRepository.findAll();
    }

    @Override
    public TextileStatus saveTextileStatus(TextileStatus textileStatus) {
        return textileStatusRepository.save(textileStatus);
    }

    @Override
    public Optional<TextileStatus> findById(int id) {
        return textileStatusRepository.findById(id);
    }
}
