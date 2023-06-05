package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.DoctorPatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Integer>{

}