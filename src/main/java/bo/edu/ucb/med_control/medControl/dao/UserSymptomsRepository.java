package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.UserSymptoms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSymptomsRepository extends JpaRepository<UserSymptoms, Integer>{}