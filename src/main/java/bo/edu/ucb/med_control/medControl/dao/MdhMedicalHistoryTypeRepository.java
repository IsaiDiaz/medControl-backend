package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MdhMedicalHistoryTypeRepository extends JpaRepository<MdhMedicalHistoryType, Integer>{}