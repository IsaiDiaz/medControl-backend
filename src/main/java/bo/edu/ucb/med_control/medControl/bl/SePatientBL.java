package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dto.SePatientDTO;
import bo.edu.ucb.med_control.medControl.entity.SePatient;
import bo.edu.ucb.med_control.medControl.dao.SePatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SePatientBL {
    private final SePatientRepository sePatientRepository;

    @Autowired
    public SePatientBL(SePatientRepository sePatientRepository) {
        this.sePatientRepository = sePatientRepository;
    }

    public List<SePatientDTO> getAllSePatients() {
        List<SePatient> sePatients = sePatientRepository.findAll();
        return sePatients.stream()
                .map(SePatientDTO::new)
                .collect(Collectors.toList());
    }

    public SePatientDTO findById(Integer id) {
        Optional<SePatient> sePatientOptional = sePatientRepository.findById(id);
        return sePatientOptional.map(SePatientDTO::new).orElse(null);
    }

    public SePatientDTO saveSePatient(SePatientDTO sePatientDTO) {
        SePatient sePatient = sePatientDTO.toEntity();
        SePatient savedSePatient = sePatientRepository.save(sePatient);
        return new SePatientDTO(savedSePatient);
    }

    public SePatientDTO updateSePatient(Integer id, SePatientDTO sePatientDTO) {
        Optional<SePatient> sePatientOptional = sePatientRepository.findById(id);
        if (sePatientOptional.isPresent()) {
            SePatient sePatient = sePatientOptional.get();
            sePatient.setPatientHeight(sePatientDTO.getPatientHeight());
            sePatient.setPatientWeight(sePatientDTO.getPatientWeight());
            sePatient.setPatientGender(sePatientDTO.getPatientGender());
            sePatient.setVersion(sePatientDTO.getVersion());
            sePatient.setStatus(sePatientDTO.isStatus());
            sePatient.setTxUser(sePatientDTO.getTxUser());
            sePatient.setTxHost(sePatientDTO.getTxHost());
            sePatient.setTxDate(sePatientDTO.getTxDate());
            SePatient updatedSePatient = sePatientRepository.save(sePatient);
            return new SePatientDTO(updatedSePatient);
        }
        return null;
    }

    public boolean deleteSePatient(Integer id) {
        Optional<SePatient> sePatientOptional = sePatientRepository.findById(id);
        if (sePatientOptional.isPresent()) {
            sePatientRepository.delete(sePatientOptional.get());
            return true;
        }
        return false;
    }
}

