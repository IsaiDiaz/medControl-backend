package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy;
import bo.edu.ucb.med_control.medControl.entity.SeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlgPatientAllergyRepository extends JpaRepository<AlgPatientAllergy, Integer>{
    @Query("SELECT a FROM AlgPatientAllergy a WHERE a.patientId.patientId = :patientId")
    List<AlgPatientAllergy> findByPatientId(@Param("patientId") Integer patientId);
}