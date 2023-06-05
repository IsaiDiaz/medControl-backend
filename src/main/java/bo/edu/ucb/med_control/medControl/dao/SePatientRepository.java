package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.SePatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SePatientRepository extends JpaRepository<SePatient, Integer>{}