package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dto.MdhMedicalHistoryDTO;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory;
import bo.edu.ucb.med_control.medControl.dao.MdhMedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MdhMedicalHistoryBL {
    private final MdhMedicalHistoryRepository mdhMedicalHistoryRepository;

    @Autowired
    public MdhMedicalHistoryBL(MdhMedicalHistoryRepository mdhMedicalHistoryRepository) {
        this.mdhMedicalHistoryRepository = mdhMedicalHistoryRepository;
    }

    public List<MdhMedicalHistoryDTO> getPatientMedicalHistories(Integer patientId) {
        List<MdhMedicalHistory> medicalHistories = mdhMedicalHistoryRepository.findByPatientId(patientId);
        return medicalHistories.stream()
                .map(MdhMedicalHistoryDTO::new)
                .collect(Collectors.toList());
    }

    public MdhMedicalHistoryDTO savePatientMedicalHistory(MdhMedicalHistoryDTO mdhMedicalHistoryDTO) {
        MdhMedicalHistory medicalHistory = mdhMedicalHistoryDTO.toEntity();
        medicalHistory = mdhMedicalHistoryRepository.saveAndFlush(medicalHistory);
        return new MdhMedicalHistoryDTO(medicalHistory);
    }

    public List<MdhMedicalHistoryDTO> savePatientMedicalHistories(List<MdhMedicalHistoryDTO> mdhMedicalHistoryDTOs) {
        List<MdhMedicalHistory> medicalHistories = mdhMedicalHistoryDTOs.stream()
                .map(MdhMedicalHistoryDTO::toEntity)
                .collect(Collectors.toList());
        medicalHistories = mdhMedicalHistoryRepository.saveAllAndFlush(medicalHistories);
        return medicalHistories.stream()
                .map(MdhMedicalHistoryDTO::new)
                .collect(Collectors.toList());
    }
}
