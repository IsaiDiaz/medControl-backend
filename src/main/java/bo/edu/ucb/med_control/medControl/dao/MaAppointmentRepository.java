package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.MaAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaAppointmentRepository extends JpaRepository<MaAppointment, Integer>{

}