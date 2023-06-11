package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface MdhMedicalHistoryRepository extends JpaRepository<MdhMedicalHistory, Integer>{
    @Query("SELECT a FROM MdhMedicalHistory a WHERE a.patientId.patientId = :patientId")
    List<MdhMedicalHistory> findByPatientId(@Param("patientId") Integer patientId);
}