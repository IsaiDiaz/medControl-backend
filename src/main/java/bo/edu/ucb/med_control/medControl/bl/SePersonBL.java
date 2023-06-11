package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dto.SePersonDTO;
import bo.edu.ucb.med_control.medControl.entity.SePerson;
import bo.edu.ucb.med_control.medControl.dao.SePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SePersonBL {
    private final SePersonRepository sePersonRepository;

    @Autowired
    public SePersonBL(SePersonRepository sePersonRepository) {
        this.sePersonRepository = sePersonRepository;
    }

    public List<SePersonDTO> getAllSePersons() {
        List<SePerson> sePersons = sePersonRepository.findAll();
        return sePersons.stream()
                .map(SePersonDTO::new)
                .collect(Collectors.toList());
    }

    public SePersonDTO findById(Integer id) {
        Optional<SePerson> sePersonOptional = sePersonRepository.findById(id);
        return sePersonOptional.map(SePersonDTO::new).orElse(null);
    }

    public SePersonDTO saveSePerson(SePersonDTO sePersonDTO) {
        SePerson sePerson = sePersonDTO.toEntity();
        SePerson savedSePerson = sePersonRepository.saveAndFlush(sePerson);
        return new SePersonDTO(savedSePerson);
    }

    public SePersonDTO updateSePerson(Integer id, SePersonDTO sePersonDTO) {
        Optional<SePerson> sePersonOptional = sePersonRepository.findById(id);
        if (sePersonOptional.isPresent()) {
            SePerson sePerson = sePersonOptional.get();
            sePerson.setPersonName(sePersonDTO.getPersonName());
            sePerson.setPersonEmail(sePersonDTO.getPersonEmail());
            sePerson.setPersonPhone(sePersonDTO.getPersonPhone());
            sePerson.setVersion(sePersonDTO.getVersion());
            sePerson.setStatus(sePersonDTO.isStatus());
            sePerson.setTxUser(sePersonDTO.getTxUser());
            sePerson.setTxHost(sePersonDTO.getTxHost());
            sePerson.setTxDate(sePersonDTO.getTxDate());
            SePerson updatedSePerson = sePersonRepository.save(sePerson);
            return new SePersonDTO(updatedSePerson);
        }
        return null;
    }

    public boolean deleteSePerson(Integer id) {
        Optional<SePerson> sePersonOptional = sePersonRepository.findById(id);
        if (sePersonOptional.isPresent()) {
            sePersonRepository.delete(sePersonOptional.get());
            return true;
        }
        return false;
    }
}
