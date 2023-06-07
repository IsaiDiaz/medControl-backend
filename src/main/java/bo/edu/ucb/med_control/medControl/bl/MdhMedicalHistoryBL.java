package bo.edu.ucb.med_control.medControl.bl;

import bo.edu.ucb.med_control.medControl.dao.MdhMedicalHistoryRepository;
import bo.edu.ucb.med_control.medControl.dto.MdhKinshipDTO;
import bo.edu.ucb.med_control.medControl.dto.MdhMedicalHistoryDTO;
import bo.edu.ucb.med_control.medControl.entity.MdhKinship;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;


@Service
public class MdhMedicalHistoryBL {
    private MdhMedicalHistoryRepository mdhMedicalHistoryRepository;
    private MdhKinshipBL mdhKinshipBL;

    public MdhMedicalHistoryBL(MdhMedicalHistoryRepository mdhMedicalHistoryRepository) {
        this.mdhMedicalHistoryRepository = mdhMedicalHistoryRepository;
    }

    @Transactional
    public MdhMedicalHistoryDTO saveMedicalHistory(MdhMedicalHistoryDTO mdhMedicalHistoryDTO) {
        MdhMedicalHistory medicalHistory = mdhMedicalHistoryDTO.toEntity();
        medicalHistory = mdhMedicalHistoryRepository.saveAndFlush(medicalHistory);
        return new MdhMedicalHistoryDTO(medicalHistory);
    }
}
