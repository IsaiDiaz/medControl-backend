package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.SePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SePersonRepository extends JpaRepository<SePerson, Integer>{}