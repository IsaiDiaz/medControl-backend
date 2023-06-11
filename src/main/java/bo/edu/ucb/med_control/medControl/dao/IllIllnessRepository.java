package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.IllIllness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IllIllnessRepository extends JpaRepository<IllIllness, Integer>{

}