package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.SeMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeMedicineRepository extends JpaRepository<SeMedicine, Integer>{}