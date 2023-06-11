package bo.edu.ucb.med_control.medControl.dao;

import bo.edu.ucb.med_control.medControl.entity.AlgAllergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AlgAllergyRepository extends JpaRepository<AlgAllergy, Integer>{

}