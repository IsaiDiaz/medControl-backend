package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdhMedicalHistoryRepository extends JpaRepository<MdhMedicalHistory, Integer>{}