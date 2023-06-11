package bo.edu.ucb.med_control.medControl.dao;


import bo.edu.ucb.med_control.medControl.entity.SeUserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SeUserGroupRepository extends JpaRepository<SeUserGroup, Integer>{}