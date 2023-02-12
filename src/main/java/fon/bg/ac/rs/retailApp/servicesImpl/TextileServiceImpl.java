package fon.bg.ac.rs.retailApp.servicesImpl;

import fon.bg.ac.rs.retailApp.dtos.TextileDto;
import fon.bg.ac.rs.retailApp.dtos.TextileMakeDto;
import fon.bg.ac.rs.retailApp.models.Textile;
import fon.bg.ac.rs.retailApp.models.TextileMake;
import fon.bg.ac.rs.retailApp.repositories.TextileRepository;
import fon.bg.ac.rs.retailApp.services.TextileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TextileServiceImpl implements TextileService {

    @Autowired
    private TextileRepository textileRepository;

    @Override
    public List<TextileDto> getTextiles() {

        List<Textile> all = textileRepository.findAll();
        List<TextileDto> dtos = all.stream()
                .map(d -> new TextileDto(d.getId(),
                        d.getUniqueCode(),
                        d.getPiecePrice(),
                        d.getSpecialDescription(),
                        d.getAvailableQuantity(),
                        d.getPhoto(),
                        d.getPurpose(),
                        d.getAcquisitionDate(),
                        d.getTextileType(),
                        d.getTextileType().getId(),
                        d.getTextleMake(),
                        d.getTextleMake().getId(),
                        d.getTextileModel(),
                        d.getTextileModel().getId(),
                        d.getTextileStatus(),
                        d.getTextileStatus().getId(),
                        d.getInCharge(),
                        d.getInCharge().getId(),
                        d.getSupplier(),
                        d.getSupplier().getId())).collect(Collectors.toList());

        return dtos;
    }

    @Override
    public TextileDto saveTextile(TextileDto textile) {

        Textile d = new Textile();
        BeanUtils.copyProperties(textile, d);

        Textile saved = textileRepository.save(d);
        textile.setId(saved.getId());
        return textile;
    }

    @Override
    public TextileDto findById(int id) {

        Textile find=textileRepository.findById(id).get();
        TextileDto d= new TextileDto();
        BeanUtils.copyProperties(find, d);

        return d;
    }

    @Override
    public void deleteById(int id) {
        textileRepository.deleteById(id);
    }

    @Override
    public List<TextileDto> findByPurpose(String purpose) {
        List<Textile> all = textileRepository.findByPurpose(purpose);
        List<TextileDto> dtos = all.stream()
                .map(d -> new TextileDto(d.getId(),
                        d.getUniqueCode(),
                        d.getPiecePrice(),
                        d.getSpecialDescription(),
                        d.getAvailableQuantity(),
                        d.getPhoto(),
                        d.getPurpose(),
                        d.getAcquisitionDate(),
                        d.getTextileType(),
                        d.getTextileType().getId(),
                        d.getTextleMake(),
                        d.getTextleMake().getId(),
                        d.getTextileModel(),
                        d.getTextileModel().getId(),
                        d.getTextileStatus(),
                        d.getTextileStatus().getId(),
                        d.getInCharge(),
                        d.getInCharge().getId(),
                        d.getSupplier(),
                        d.getSupplier().getId())).collect(Collectors.toList());

        return dtos;
    }
}
