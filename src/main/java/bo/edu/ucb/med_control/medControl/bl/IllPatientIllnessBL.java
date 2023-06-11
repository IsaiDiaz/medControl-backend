package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dto.IllPatientIllnessDTO;
import bo.edu.ucb.med_control.medControl.entity.IllPatientIllness;
import bo.edu.ucb.med_control.medControl.dao.IllPatientIllnessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IllPatientIllnessBL {
    private final IllPatientIllnessRepository illPatientIllnessRepository;

    @Autowired
    public IllPatientIllnessBL(IllPatientIllnessRepository illPatientIllnessRepository) {
        this.illPatientIllnessRepository = illPatientIllnessRepository;
    }

    public List<IllPatientIllnessDTO> getPatientIllnesses(Integer patientId) {
        List<IllPatientIllness> illnesses = illPatientIllnessRepository.findByPatientId(patientId);
        List<IllPatientIllnessDTO> illnessDTOS = new ArrayList<>();
        for (IllPatientIllness illness : illnesses) {
            IllPatientIllnessDTO illnessDTO = new IllPatientIllnessDTO(illness);
            illnessDTOS.add(illnessDTO);
        }
        return illnessDTOS;
    }

    public IllPatientIllnessDTO savePatientIllness(IllPatientIllnessDTO illPatientIllnessDTO) {
        IllPatientIllness illness = illPatientIllnessDTO.toEntity();
        illness = illPatientIllnessRepository.saveAndFlush(illness);
        return new IllPatientIllnessDTO(illness);
    }

    public List<IllPatientIllnessDTO> savePatientIllnesses(List<IllPatientIllnessDTO> illPatientIllnessDTOs) {
        List<IllPatientIllness> illnesses = illPatientIllnessDTOs.stream()
                .map(IllPatientIllnessDTO::toEntity)
                .collect(Collectors.toList());
        illnesses = illPatientIllnessRepository.saveAllAndFlush(illnesses);
        return illnesses.stream()
                .map(IllPatientIllnessDTO::new)
                .collect(Collectors.toList());
    }
}
