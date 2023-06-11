package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dto.AlgPatientAllergyDTO;
import bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy;
import bo.edu.ucb.med_control.medControl.dao.AlgPatientAllergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlgPatientAllergyBL {
    private final AlgPatientAllergyRepository algPatientAllergyRepository;

    @Autowired
    public AlgPatientAllergyBL(AlgPatientAllergyRepository algPatientAllergyRepository) {
        this.algPatientAllergyRepository = algPatientAllergyRepository;
    }

    public List<AlgPatientAllergyDTO> getPatientAllergies(Integer patientId) {
        List<AlgPatientAllergy> allergies = algPatientAllergyRepository.findByPatientId(patientId);
        List<AlgPatientAllergyDTO> allergyDTOS = new ArrayList<>();
        for (AlgPatientAllergy allergy : allergies) {
            AlgPatientAllergyDTO allergyDTO = new AlgPatientAllergyDTO(allergy);
            allergyDTOS.add(allergyDTO);
        }
        return allergyDTOS;
    }

    public AlgPatientAllergyDTO savePatientAllergy(AlgPatientAllergyDTO algPatientAllergyDTO) {
        AlgPatientAllergy allergy = algPatientAllergyDTO.toEntity();
        allergy = algPatientAllergyRepository.saveAndFlush(allergy);
        return new AlgPatientAllergyDTO(allergy);
    }

    public List<AlgPatientAllergyDTO> savePatientAllergies(List<AlgPatientAllergyDTO> algPatientAllergyDTOs) {
        List<AlgPatientAllergy> allergies = algPatientAllergyDTOs.stream()
                .map(AlgPatientAllergyDTO::toEntity)
                .collect(Collectors.toList());
        allergies = algPatientAllergyRepository.saveAllAndFlush(allergies);
        return allergies.stream()
                .map(AlgPatientAllergyDTO::new)
                .collect(Collectors.toList());
    }
}
