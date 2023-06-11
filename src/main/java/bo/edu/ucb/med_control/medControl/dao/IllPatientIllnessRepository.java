package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy;
import bo.edu.ucb.med_control.medControl.entity.IllPatientIllness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IllPatientIllnessRepository extends JpaRepository<IllPatientIllness, Integer>{
    @Query("SELECT a FROM IllPatientIllness a WHERE a.patientId.patientId = :patientId")
    List<IllPatientIllness> findByPatientId(@Param("patientId") Integer patientId);
}